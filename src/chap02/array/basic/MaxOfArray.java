package chap02.array.basic;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArray {

    private Scanner sc;
    private Random random = new Random();

    public void start(){

        sc = new Scanner(System.in);
        //System.out.print("키의 최대값을 구합니다.\n사람수 : ");

        //int people = sc.nextInt();
        //int[] array = this.makeArray(people);

        int people = random.nextInt(10);
        int[] array = this.makeRanArray(people);

        this.methodMax(array);

    }

    /**
     * 난수로 배열 생성
     */
    private int[] makeRanArray(int people){

        int[] array = new int[people];

        for (int i = 0; i < people; i++){
            array[i] = 100 + random.nextInt(90);
        }

        return array;

    }

    /**
     * 배열 값 직접 입력
     */
    private int[] makeArray(int people){

        int[] array = new int[people];

        for (int i = 0; i < people; i++){
            System.out.print("height[" + i + "]: ");
            array[i] = sc.nextInt();
        }

        return array;

    }

    /**
     * 최대값 계산
     */
    private void methodMax(int[] array){

        int max = array[0];

        for(int element : array){
            if(max < element) max = element;
        }

        System.out.println("max value: " + max);

    }

}
