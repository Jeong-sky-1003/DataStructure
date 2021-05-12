package barkingdog.chap0B;

import caseStudy.MyStart;

import java.util.Scanner;

public class Example implements MyStart {

    @Override
    public void start() throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println("출력하기");
        example01(num);

        System.out.println("합하여 결과 출력하기");
        int result = example02(num);
        System.out.printf("result: %d\n", result);

    }

    // num부터 1까지 출력
    private void example01(int num) {
        if (num == 0) return;
        else {
            System.out.println(num);
            example01(num - 1);
        }
    }

    // num까지의 합 구하기
    private int example02(int num) {
        if (num == 1) return 1;
        else
            return num + example02(num - 1);
    }

}
