package chap02.array.basic;

import java.util.Scanner;

public class CardConvRev2_8 {

    private int resultIndex;

    private Scanner sc;
    private char[] result;

    private ReverseArray reverseArray;
    private final static String DCHAR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CardConvRev2_8() {

        resultIndex = 0;

        sc = new Scanner(System.in);
        reverseArray = new ReverseArray();

    }

    public void start() {

        int continueChk = 0;

        do {

            int[] data = this.calculateInit();

            this.cardConv(data[0], data[1]);
            this.print(data[1], result);

            System.out.print("한 번 더 할까요? (1: 예 / 0: 아니오) : ");
            continueChk = sc.nextInt();

        } while (continueChk == 0);

    }

    private int[] calculateInit() {

        int mod = 0;
        int number = 0;
        result = new char[40];

        do {
            System.out.print("10진수를 기수 변환합니다.\n변환하는 음이 아닌 정수 : ");
            number = sc.nextInt();
        } while (number < 1);

        do {
            System.out.print("어떤 진수로 변환할까요? (2 ~ 36) : ");
            mod = sc.nextInt();
        } while (mod < 2 && mod > 36);

        return new int[]{number, mod};

    }

    private void cardConv(int number, int mod) {

        do {

            int calculate = number % mod;
            number /= mod;

            result[resultIndex++] = DCHAR.charAt(calculate);

        } while (number > 0);

        reverseArray.reverseArray(result);

    }

    private void print(int mod, char[] array) {

        System.out.print(mod + "진수로는 ");

        for (char element : array) {
            System.out.print(element);
        }

        System.out.println("입니다.");

    }

}
