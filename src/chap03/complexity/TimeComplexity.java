package chap03.complexity;

import chap03.Chapter03;

public class TimeComplexity implements Chapter03 {

    @Override
    public void start() {


    }

    private int seqSearch(int[] a, int n, int key) {

        for (int i = 0; i < n; i++) {
            if (a[i] == key) return i;
        }

        return -1;

    }


}
