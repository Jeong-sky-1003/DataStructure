package barkingdog.chap03;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13300 implements MyStart {

    @Override
    public void start() throws Exception {
        cal_code();
    }

    private void cal_code() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");

        int result = 0;

        int num = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int [][]grades = new int[6][2];

        for (int i=0; i < num; i++) {

            inputs = reader.readLine().split(" ");

            int gender = Integer.parseInt(inputs[0]);
            int grade = Integer.parseInt(inputs[1]) - 1;

            // 값이 0일 때 카운트하는 이유는 이미 geder와 grade와 같은 index 값을 가진 것 자체가 한 명이 추가된다는 뜻임
            // 그렇기에 값이 0일 때 카운트되는 것임.
            if ( grades[grade][gender] % k == 0 || grades[grade][gender] == 0) {
                result++;
            }
            grades[grade][gender]++;

        }

        System.out.println(result);

    }

    private void cal() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []input = reader.readLine().split(" ");

        int [][]grades = new int[6][2];
        int result = 0;

        int num = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for (int i=0; i < num; i++) {

            input = reader.readLine().split(" ");

            int gender = Integer.parseInt(input[0]);
            int grade = Integer.parseInt(input[1]) - 1;

            grades[grade][gender]++;

        }

        for (int x=0; x < 6; x++) {
            for (int y=0; y <= 1; y++) {
                if ( grades[x][y] != 0 ){
                    int cal = grades[x][y] / k;
                    if (grades[x][y] % k != 0)
                        cal++;
                    result += cal;
                } else {
                    continue;
                }
            }
        }

        System.out.println(result);

    }

}
