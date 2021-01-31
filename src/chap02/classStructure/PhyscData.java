package chap02.classStructure;

import jdk.nashorn.internal.objects.annotations.Getter;
import sun.misc.VM;

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

    public String getName(){
        return this.name;
    }

    public int getHeight(){
        return this.height;
    }

    public double getVision(){
        return this.vision;
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
                new PhyscData("함진아",173, 0.7),
                new PhyscData("최윤미",175, 2.0),
                new PhyscData("홍연의",171, 1.5),
                new PhyscData("이수진",168, 0.4),
                new PhyscData("김영준",174, 1.2),
                new PhyscData("박용규",169, 0.8),
        };

        int[] vdist = new int[VMAX];

        for (PhyscData element : data){
            System.out.printf("%-8s%3d%5.1f\n",
                                element.getName(), element.getHeight(), element.getVision());
        }

        System.out.printf("\n평균키 : %5.1fcm\n", getAvgHeight(data));

        getDistVision(data, vdist);

        System.out.println("\n시력 분포");
        for (int i = 0; i < VMAX; i++){
            System.out.printf("%3.1f ~ : %2d명\n", i / 10.0, vdist[i]);
        }

    }

}
