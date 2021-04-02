package baekjoon.function;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Function10818 implements MyStart {

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        String []numbers = reader.readLine().split(" ");

        int max = Integer.parseInt(numbers[0]);
        int min = Integer.parseInt(numbers[0]);

        for (int i=1; i < number; i++){

            int tmp = Integer.parseInt(numbers[i]);

            if ( max < tmp ) max = tmp;
            if ( min > tmp ) min = tmp;

        }

        System.out.printf("%d %d", min, max);

    }

}
