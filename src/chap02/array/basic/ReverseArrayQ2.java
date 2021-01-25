package chap02.array.basic;

import java.util.Random;

public class ReverseArrayQ2 {

    private int[] array;
    private Random random;

    public void start(){

        array = new int[6];
        random = new Random();

        this.makeArray(array);
        this.reverseArray(array);

    }

    // 배열 생성
    private void makeArray(int[] array){
        for (int i=0; i < array.length;i++ ){
            array[i] = random.nextInt(50);
        }
    }

    // 배열 역순
    private void reverseArray(int[] array){
        for (int i = 0; i < array.length/2; i++){
            this.print(array);
            System.out.printf("array[%d]과(와) array[%d]를 교환합니다.\n", i, array.length - i - 1);
            this.swapArray(array, i, array.length - i - 1);
        }
        this.print(array);
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    // 배열 출력
    private void print(int[] array){
        for (int element : array){
            System.out.print(element + " ");
        }
        System.out.println("");
    }

    // swap
    private void swapArray(int[] array, int idx1, int idx2){
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

}
