package chap02.array.basic;

import java.util.Scanner;

public class ArrayEqual {

    private int[] a;
    private int[] b;
    private Scanner sc;

    public ArrayEqual() {
        sc = new Scanner(System.in);
    }

    public void start() {

        System.out.print("배열 a의 요솟수: ");
        a = new int[sc.nextInt()];
        this.makeArray(a);

        System.out.print("배열 b의 요솟수: ");
        b = new int[sc.nextInt()];
        this.makeArray(b);

        String result = "배열 a와 b는 " + (this.chkEquals(a, b) ? "같습니다." : "같지 않습니다.");
        System.out.println(result);

    }

    // 배열 생성
    private void makeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("a[%d]: ", i);
            array[i] = sc.nextInt();
        }
    }

    // 배열 체크
    private boolean chkEquals(int[] a, int[] b) {

        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;

    }

}
