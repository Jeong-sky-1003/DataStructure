package baekjoon.function;

import baekjoon.BackJoon;

public class Function1065 implements BackJoon {

    private boolean hanNumberChk(int n) {

        boolean chk = false;
        char[] list = String.valueOf(n).toCharArray();

        int len = list.length;
        int[] numberList = new int[len];

        for (int i = 0; i < len; i++) {
            numberList[i] = Character.getNumericValue(list[i]);
        }

        int gong = -1 * (numberList[0] - numberList[1]);
        for (int i = 0; i < len - 1; i++) {

            int tmp = numberList[i] + gong;

            if (tmp == numberList[i + 1]) {
                chk = true;
            } else {
                chk = false;
            }

        }

        return chk;

    }

    private int hanCheck(int num) {

        int count = 0;
        for (int i = 1; i <= num; i++) {

            if (i < 100) count++;
            else {

                int a = i / 100;
                int b = (i % 100) / 10;
                int c = i % 10;

                if ((b - a) == (c - b)) count++;

            }

        }
        return count;

    }

    ;

    @Override
    public void start() {

        int N = sc.nextInt();
        int count = hanCheck(N);

        System.out.printf("result: %d", count);

    }

}
