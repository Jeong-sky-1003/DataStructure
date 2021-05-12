package barkingdog.chap0B;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1629 implements MyStart {

    // 이해가 안되니 그냥 외우자..
    private long mod(int a, int b, int c) {

        if (b == 1) return a;

        long val = mod(a, b/2, c) % c;

        if (b % 2 == 0)
            return (val * val) % c;
        else
            return (((val * val) % c) * a) % c;

    }

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        long result = mod(a % c, b, c);
        System.out.println(result);

    }

    private void started() throws Exception {

        // 입력 값의 각 최대 범위는 Integer.MAX_VALUE
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        long result = mode(a, b, c);
        System.out.println(result);

    }

    // https://onsil-thegreenhouse.github.io/programming/problem/2018/03/29/problem_math_power/
    private long mode(int a, int b, int c) {
        if (b < 1) return 1;
        else if ( b == 1 ) return a;
        else if ( b%2 == 0 ) {
            // 짝수 지수
            long val = mode(a, b/2, c) % c;
            return (val * val) % c;
        } else {
            // 홀수 지수
            long val = mode(a, b/2, c) % c;
            return (((val * val) % c) * a) % c;
        }
    }

}
