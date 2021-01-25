package chap02.array.basic;

import java.util.Scanner;

public class ReverseArray {

    private Scanner sc;

    public void start(){

        int[] array;
        sc = new Scanner(System.in);

        System.out.print("요소 수: ");
        array = new int[sc.nextInt()];

        this.makeArray(array);
        for (int element : array){
            System.out.print(element + " ");
        }

        this.reverseArray(array);
        for (int element : array){
            System.out.print(element + " ");
        }

    }

    private void makeArray(int[] array){

        for (int i = 0; i < array.length; i++){
            System.out.print("array["+i+"] : ");
            array[i] = sc.nextInt();
        }

    }

    // 역순 정렬 반복문
   private void reverseArray(int[] array){
        for (int i = 0; i < array.length/2; i++){
            this.swap(array, i, array.length - i - 1);
        }
    }

    // 바꾸기
    private void swap(int[] array, int idx1, int idx2){
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    public void reverseArray(char[] array){
        for (int i = 0; i < array.length/2; i++){
            this.swap(array, i, array.length - i - 1);
        }
    }

    private void swap(char[] array, int idx1, int idx2){
        char tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }


}
