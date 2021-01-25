package chap02.array.basic;

import java.util.Scanner;

public class CardConvRev_Q7 {

    private int mod;
    private int index;
    private Scanner sc;

    private char[] result;
    private final static String DCHAR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CardConvRev_Q7(){
        sc = new Scanner(System.in);
    }

    public void start(){

        index = 0;
        result = new char[30];

        int number = 0;

        System.out.println("10진수를 기수 변환합니다.");

        do {
            System.out.print("변환하는 음이 아닌 정수 : ");
            number = sc.nextInt();
        } while (number < 1);

        do {
            System.out.print("어떤 진수로 변환할까요?(2-36) : ");
            mod = sc.nextInt();
        } while (mod < 1);

        this.convRev(number, mod, result);

        System.out.print( mod + "진수로 ");
        for (int i = result.length - 1; i > -1; i--){
            System.out.print(result[i]);
        }

        System.out.println("입니다.");

    }

    private void convRev(int number, int mod, char[] array){

        System.out.printf("%d | %4d\n", mod, number);

        do {

            int calculate = number % mod;
            number /= mod;
            array[index++] = DCHAR.charAt(calculate);
            this.print(number, calculate);

        } while (number != 0);

    }

    private void print(int number, int calculate){

        System.out.println("  +-------");
        if (number == 0){
            System.out.printf("%8d   ... %d\n", number, calculate);
        } else {
            System.out.printf("%d | %4d   ... %d\n", mod, number, calculate);
        }

    }

}
