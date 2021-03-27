package chap04.recursive;

import chap04.Chap04;

public class QueenB implements Chap04 {

    private int[] pos = new int[8];

    private void print() {
        for (int e : pos)
            System.out.printf("%2d", e);
        System.out.println("\n-------------------------");
    }

    private void set(int i) {

        for (int j = 0; j < 8; j++) {
            pos[i] = j;
            System.out.printf("i:%2d, j:%2d\n", i, j);
            if (i == 7) {
                print();
            } else {
                set(i + 1);
            }
        }

    }

    @Override
    public void start() {
        set(0);
    }

}
