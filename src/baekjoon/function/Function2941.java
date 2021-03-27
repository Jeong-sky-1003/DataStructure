package baekjoon.function;

import baekjoon.BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Function2941 implements BackJoon {

    private void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] list = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < list.length; i++) {
            if (input.contains(list[i])) {
                // 위 배열 내에 존재하는 것들은 엄밀히 하나의 문자이기에 하나의 문자로 치환
                input = input.replace(list[i], "*");
            }
        }

        System.out.println(input.length());

    }

    @Override
    public void start() throws Exception {
        run();
    }

}
