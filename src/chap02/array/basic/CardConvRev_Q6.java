package chap02.array.basic;

import java.util.Scanner;

public class CardConvRev_Q6 {

    private int index = 0;

    private Scanner sc;
    private final static String DCHAR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CardConvRev_Q6() {
        sc = new Scanner(System.in);
    }

    public void start() {

        char[] dChar = new char[40];

        System.out.print("양수의 10진수 값 : ");
        int number = sc.nextInt();

        System.out.print("변환할 기수 : ");
        int r = sc.nextInt();

        number = this.cardConv(number, r, dChar);

        System.out.println(number + "자리수");
        for (char element : dChar) {
            System.out.print(element);
        }

    }

    private int cardConv(int x, int r, char[] d) {

        do {

            int calculate = x % r;
            x /= r;

            d[index++] = DCHAR.charAt(calculate);

        } while (x != 0);

        return index;

    }

}
