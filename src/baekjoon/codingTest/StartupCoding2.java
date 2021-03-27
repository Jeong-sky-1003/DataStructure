package baekjoon.codingTest;

import baekjoon.BackJoon;

import java.io.*;

public class StartupCoding2 implements BackJoon {

    private void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int runCount = Integer.parseInt(input);

        for (int i = 0; i < runCount; i++) {

            String testCase = br.readLine();
            String[] numbers = testCase.split(" ");

            long n = Long.parseLong(numbers[0]);
            long m = Long.parseLong(numbers[1]);

            long result1 = n / 5;
            long result2 = (n + m) / 12;

            long result = (result1 <= result2) ? result1 : result2;
            System.out.println(result);

        } // 전체 for문

        br.close();

    }

    @Override
    public void start() throws Exception {
        this.run();
    }

}
