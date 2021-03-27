package baekjoon.function;

import baekjoon.BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Function2908 implements BackJoon {

    // 코드 길이는 run2가 더 짧으나 코드 속도는 run이 더 빠름
    private void run2() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int num1 = Integer.parseInt(input.split(" ")[0]);
        int num2 = Integer.parseInt(input.split(" ")[1]);

        num1 = ((num1 % 10) * 100) + ((num1 / 10 % 10) * 10) + (num1 / 100);
        num2 = ((num2 % 10) * 100) + ((num2 / 10 % 10) * 10) + (num2 / 100);

        System.out.println(num1 > num2 ? num1 : num2);

    }

    private void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        char[] num1 = input.split(" ")[0].toCharArray();
        char[] num2 = input.split(" ")[1].toCharArray();

        for (int i = 2; i > -1; i--) {

            if (num1[i] > num2[i]) {
                this.print(num1);
                break;
            } else if (num1[i] == num2[i]) {
                continue;
            } else {
                this.print(num2);
                break;
            }

        }

    }

    private void print(char[] result) {
        for (char e : result)
            System.out.print(e);
    }

    @Override
    public void start() throws Exception {
        run();
    }

}
