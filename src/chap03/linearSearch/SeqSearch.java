package chap03.linearSearch;

import chap03.Chapter03;

import java.util.Scanner;

public class SeqSearch implements Chapter03 {

    private Scanner sc;

    public SeqSearch(){
        sc = new Scanner(System.in);
    }

    private int seqSearch(int[] list, int number){

        for (int i=0; i < list.length; i++){
            if (list[i] == number) return i;
        }

        return -1;

    }

    private void print(int number, int result){
        if (result > -1) System.out.printf("%d는 x[%d]에 있습니다.", number, result);
        else System.out.println("값이 존재하지 않습니다.");
    }

    @Override
    public void start() {

        System.out.print("요솟수: ");
        int number = sc.nextInt();

        int[] list = new int[number];
        for (int i = 0; i < number; i++){
            System.out.printf("x[%d] : ", i);
            list[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : ");
        number = sc.nextInt();

        int result = seqSearch(list, number);
        print(number, result);

    }

}
