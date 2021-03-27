package baekjoon.function;

import baekjoon.BackJoon;

public class Function4376 implements BackJoon {

    private int getNum(int n, int k) {
        if (n < 1) return 1;
        else {
            return 10 * getNum(n - 1, 10);
        }
    }

    @Override
    public void start() {
        // 자리수 n-1하여 넘길 것
        int result = getNum(3 - 1, 10);
        System.out.println(result);
    }

}
