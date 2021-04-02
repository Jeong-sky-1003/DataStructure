package baekjoon.function;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Function2501 implements MyStart {

    @Override
    public void start() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);

        int count = 0;

        for (int i=1; i <= n; i++){

            if ( (n%i) == 0 ) count++;

            if ( count == k ) {
                System.out.println(i);
                return;
            }

        }

        System.out.println(0);

    }

}
