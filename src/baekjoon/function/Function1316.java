package baekjoon.function;

import baekjoon.BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Function1316 implements BackJoon {

    private boolean check(String str) {

        boolean[] chk = new boolean[26];
        int len = str.length();

        for (int i=0; i < len; i++){

            int index = str.charAt(i) - 'a';
            if ( chk[index] )
                return false;
            else if ( i < len-1 && str.charAt(i) != str.charAt(i+1) ) {
                chk[index] = true;
            }

        }
        return true;

    }

    private void run() throws Exception {

        int result = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int num = Integer.parseInt(input);

        for ( int i=0; i < num; i++ ) {
            String str = reader.readLine();
            boolean chk = check(str);
            if (chk) result++;
        }

        System.out.println("--------------------");
        System.out.println(result);

    }

    @Override
    public void start() throws Exception {
        run();
    }

}
