package barkingdog.chap03;

import caseStudy.MyStart;

import java.util.ArrayList;
import java.util.List;

public class Question1 implements MyStart {

    int len = 6;

    // 역시 자바는 ArrayList를 쓰는게....
    @Override
    public void start() throws Exception {
        int []array = {10, 50, 40, 30, 70, 20};
        print(array);
        array=insert_2(0, 60, array);
        print(array);
        array=erase(4, array);
        print(array);

        List<Integer> a = new ArrayList<>();

    }

    private void print(int[] arr) {
        for (int i=0;i<len;i++) System.out.print(arr[i]+" ");
        System.out.println("\n---------------------");
    }

    // 하늘
    private int[] insert(int index, int number, int []array) {
        int []tmp = array.clone();
        array = new int[++len];
        for (int i=0; i < len; i++){
            if ( i < index ) array[i] = tmp[i];
            else if ( i == index ) array[i] = number;
            else array[i] = tmp[i-1];
        }
        return array;
    }

    // 바킹독 접근: 끝에서부터
    private int[] insert_2(int index, int num, int []array) {
        int []tmp = array.clone();
        array = new int[++len];
        for (int i=len-1; i > index; i--)
            array[i] = tmp[i-1];
        array[index] = num;
        for (int i=0; i < index; i++)
            array[i] = tmp[i];
        return array;
    }

    private int[] erase(int index, int []array) {
        int []tmp = array.clone();
        array = new int[--len];
        for (int i=0; i < len; i++){
            if (i>=index) array[i] = tmp[i+1];
            else if (i<index)array[i]=tmp[i];
        }
        return array;
    }

}
