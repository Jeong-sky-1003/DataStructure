package baekjoon.array;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10808 implements MyStart {

    @Override
    public void start() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int []result = solve(input);
        for (int i=0; i < result.length; i++)
            System.out.printf("%d ", result[i]);
    }

    private int[] solve(String str) {
        int[] result = new int['z'-'a'+1];
        for (int i=0; i < str.length(); i++)
            result[ str.charAt(i) - 'a' ] += 1;
        return result;
    }

}
