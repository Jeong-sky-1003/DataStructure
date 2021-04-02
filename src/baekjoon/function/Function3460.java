package baekjoon.function;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Function3460 implements MyStart {

    @Override
    public void start() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i=0; i < num; i++){

            int number = Integer.parseInt(br.readLine());
            String binaryNumber = Integer.toBinaryString(number);

            for (int j=binaryNumber.length()-1; j >= 0; j--) {

                if ( binaryNumber.charAt(j) == '1' ) {
                    System.out.print( (binaryNumber.length() - 1 - j) + " " );
                }

            }

            System.out.println();

        }

    }

}
