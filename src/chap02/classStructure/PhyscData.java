package chap02.classStructure;

import jdk.nashorn.internal.objects.annotations.Getter;
import sun.misc.VM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyscData implements ClassStructure{

    private static final int VMAX = 21;

    private String name;
    private int height;
    private double vision;
    private Scanner sc;

    public PhyscData(){
        sc = new Scanner(System.in);
    }

    // 생성자
    public PhyscData(String name, int height, double vision) {
        this.name = name;
        this.height = height;
        this.vision = vision;
    }

    public String toString(){
        return name + " " + height + " " + vision;
    }

    public String getName(){
        return this.name;
    }

    public int getHeight(){
        return this.height;
    }

    public double getVision(){
        return this.vision;
    }

    // 오름차순 정렬을 위한 comperator
    public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

    private static class HeightOrderComparator implements Comparator<PhyscData>{
        // 자연정렬이 안 되어 있는 경우 Comperator를 상속 받아 compare 구현함
        // 이는 자바에 내장된 binarySearch에 대한 이진 타입 정렬임
        @Override
        public int compare(PhyscData d1, PhyscData d2) {
            return  (d1.height > d2.height) ? 1 :
                    (d1.height < d2.height) ? -1 : 0;
        }

    }

    // 신장에 해당하는 학생 검색하기
    private int getStudent(PhyscData[] datas, int height){
        return Arrays.binarySearch( datas,
                                    new PhyscData("", height, 0.0),
                                    PhyscData.HEIGHT_ORDER);
    }

    // 평균 키 계산
    public double getAvgHeight(PhyscData[] data){

        double result = 0;

        for (PhyscData element : data){
            result += element.getHeight();
        }

        return result/data.length;

    }

    // 시력 분포 계산
    public void getDistVision(PhyscData[] data, int[] dist){

        int index = 0;
        dist[index] = 0;

        for (PhyscData element:data){
            double vision = element.getVision();
            /*
                시력 범위가 올바르게 입력되어 있다면
                해당 시력을 정수화한 범위를 index 번호로 환산한 곳에 1을 증가하라
             */
            if (vision >= 0.0 && vision <= (VMAX/10.0))
                dist[(int)(element.getVision() * 10)]++;
        }

    }

    @Override
    public void start() {

        PhyscData[] data = {
                new PhyscData("박현규",162, 0.3),
                new PhyscData("함진아",168, 0.7),
                new PhyscData("최윤미",169, 2.0),
                new PhyscData("홍연의",171, 1.5),
                new PhyscData("이수진",173, 0.4),
                new PhyscData("김영준",174, 1.2),
                new PhyscData("박용규",175, 0.8),
        };

        int[] vdist = new int[VMAX];

        for (PhyscData element : data){
            System.out.printf("%-8s%3d%5.1f\n",
                                element.getName(), element.getHeight(), element.getVision());
        }

        System.out.printf("\n평균키 : %5.1fcm\n", getAvgHeight(data));

//        getDistVision(data, vdist);
//
//        System.out.println("\n시력 분포");
//        for (int i = 0; i < VMAX; i++){
//            System.out.printf("%3.1f ~ : %2d명\n", i / 10.0, vdist[i]);
//        }

        System.out.print("몇 cm인 사람을 찾고 있나요? : ");
        int key = sc.nextInt();
        int result = this.getStudent(data, key);
        System.out.println(result);

        if (result < 0) System.out.println("요소가 없습니다.");
        else {
            System.out.printf("x[%d]에 존재합니다.\n", result);
            System.out.printf("찾은 데이터: %d", key);
        }

    }

}
