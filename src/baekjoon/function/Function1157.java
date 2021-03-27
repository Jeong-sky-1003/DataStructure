package baekjoon.function;

import baekjoon.BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class Function1157 implements BackJoon {


    private void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        input = input.toLowerCase(Locale.ROOT);

        int[] result = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int position = (int) input.charAt(i) - 97;
            result[position] += 1;
        }

        int max = -1;
        char c = '?';

        for (int i = 0; i < 26; i++) {

            if (max < result[i]) {
                max = result[i];
                c = (char) (i + 'A');
            } else if (max == result[i] && result[i] != 0) {
                c = '?';
            }

        }

        System.out.println(c);

    }

    @Override
    public void start() throws Exception {
        run();
    }

}
