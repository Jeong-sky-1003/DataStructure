package barkingdog.chap0B;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1074 implements MyStart {

    static int row, column, num;

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        num = Integer.parseInt(inputs[0]);
        row = Integer.parseInt(inputs[1]);
        column = Integer.parseInt(inputs[2]);

        int result = move(row, column,num);
        System.out.println(result);

    }

    /*
        Base Condition
            - n = 0 일 때, return 0;
        재귀 식

            half : 한 변 길이의 절반. 2의 n-1승

            - row, column => 1번 사각형 : return func(r, c, n-1);
            - row, column => 2번 사각형 : return half * half + func(r, c - half, n-1);
            - row, column => 3번 사각형 : return 2 * half * half + func(r - half, c, n-1);
            - row, column => 4번 사각형 : return 3 * half * half + func(r - half, c - half, n-1);
     */
    int move(int row, int column, int num) {

        if (num == 0) return 0;
        else {

            int cal = 0;
            int half = (int) Math.pow(2, num - 1);
            System.out.printf("half: %d, row: %d, column: %d\n" ,half, row, column);
            // row 혹은 column 에서 half를 빼는 이유는 접근한 수만큼 빼주기 위함

            if ( row < half && column < half ) {

                // 1번 사각형
                System.out.printf("1번 사각형 접근\n");
                cal = move(row, column, num - 1);
                System.out.printf("1번 사각형 : %d\n", cal);
                return cal;

            } else if ( row >= half && column < half ) {

                // 3번 사각형
                System.out.printf("3번 사각형 접근\n");
                cal = 2 * half * half + move(row - half, column, num - 1);
                System.out.printf("3번 사각형 : %d\n", cal);
                return cal;

            } else if ( row < half && column >= half ) {

                // 2번 사각형
                System.out.printf("2번 사각형 접근\n");
                cal = half * half + move(row, column - half, num - 1);
                System.out.printf("2번 사각형 : %d\n", cal);
                return cal;

            }

            // 4번 사각형
            System.out.printf("4번 사각형 접근\n");
            cal = 3 * half * half + move(row - half, column - half, num - 1);
            System.out.printf("4번 사각형 : %d\n", cal);
            return cal;

        }

    }

}
