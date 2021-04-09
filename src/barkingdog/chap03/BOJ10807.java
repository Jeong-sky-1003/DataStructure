package barkingdog.chap03;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10807 implements MyStart {

    @Override
    public void start() throws Exception {
        solve2();
    }

    private void solve2() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);
        int []result = new int[201];

        String []strings = reader.readLine().split(" ");
        for (int i=0; i < num; i++) {
            int index = Integer.parseInt(strings[i]) + 100;
            result[index]++;
        }

        num = Integer.parseInt(reader.readLine());
        System.out.println(result[num+100]);

    }

    private void solve1() throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);
        int result = 0;

        String strings = reader.readLine();
        String findNum = reader.readLine();

        while (true) {
            int index = strings.indexOf(findNum);
            if ( index > -1 ) {
                result++;
                strings = strings.substring(index+1);
            } else {
                break;
            }
        }

        System.out.println(result);
    }

}
