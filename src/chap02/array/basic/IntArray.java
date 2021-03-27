package chap02.array.basic;

public class IntArray {

    public void IntArrayMethod() {

        int[] a = new int[5];

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        for (int element : a) {
            System.out.println(element);
        }

    }

}
