package baekjoon.function;

import baekjoon.BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Function5622 implements BackJoon {

    private void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int[] numbers = {   2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
                            7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };

        int result = 0;
        for (int i = 0; i < input.length(); i++ ){
            int index = (int) (input.charAt(i) - 'A');
            result = result + numbers[index] + 1;
        }

        System.out.println(result);

    }

    @Override
    public void start() throws Exception {
        run();
    }

}
