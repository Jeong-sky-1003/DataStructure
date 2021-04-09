package barkingdog.chap03;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1919 implements MyStart {

    @Override
    public void start() throws Exception {
        solve_stranger();
    }

    private void solve_stranger() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = reader.readLine();
        String str2 = reader.readLine();

        int result = 0;
        int []flag = new int[26];

        for (int i=0; i < str1.length(); i++)
            ++flag[ str1.charAt(i) - 'a' ];

        // 같은 char을 같은 갯수로 가질 경우 연산한 값이 0이되며,
        // 같은 char를 더 많이 갖고 있거나 더 적게 갖고 있을 경우 그만큼을 합하면 없애야할 갯수 계산 가능
        for (int i=0; i < str2.length(); i++)
            --flag[ str2.charAt(i) - 'a' ];

        for (int i=0; i < 26; i++) {
            result += Math.abs(flag[i]);
        }

        System.out.println(result);

    }

    private void solve_sky() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str_1 = reader.readLine();
        String str_2 = reader.readLine();

        int result = 0;

        int []flag_a = new int[26];
        int []flag_b = new int[26];

        for (int i=0; i < str_1.length(); i++) {
            int index = str_1.charAt(i) - 'a';
            flag_a[index]++;
        }

        for (int i=0; i < str_2.length(); i++) {
            int index = str_2.charAt(i) - 'a';
            flag_b[index]++;
        }

        for (int i=0; i < 26; i++ ) {
            result += Math.min(flag_a[i], flag_b[i]);
        }

        result = (str_1.length() - result) + (str_2.length() - result);
        System.out.println(result);

    }

}
