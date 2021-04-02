package baekjoon.stack;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Function17298 implements MyStart {

    static int num = 0;
    static char[] numbers;

    @Override
    public void start() throws Exception {
        code1();
    }

    // 시간 초과
    private void code1() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(reader.readLine());
        String input = reader.readLine();

        input = input.replace(" ", "");
        numbers = input.toCharArray();

        for (int i=0; i < num; i++ ){

            if ( i == num - 1 ){
                writer.append(-1 + " ");
                break;
            }

            if ( i < num-1 ) {
                char tmp = run(numbers, i);
                if (tmp == '0') writer.append(-1 + " ");
                else writer.append( tmp + " ");
            }

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    private static char run(char[] numbers, int index) {

        for ( int j = index+1; j < num; j++ ){
            if ( numbers[index] < numbers[j] ) {
                return numbers[j];
            }
        }
        return '0';

    }

}
