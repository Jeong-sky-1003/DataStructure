package barkingdog.chap03;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1475 implements MyStart {

    @Override
    public void start() throws Exception {
        run();
    }

    // 한 세트에 0 ~ 9까지 들어있으며, 필요한 최소 세트 수는?
    // 단, 6과 9는 뒤집어 사용할 수 있음
    private void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        int result = 0;
        int []chk_flag = new int[10];

        for (int i=0; i < input.length(); i++ ){

            int index = input.charAt(i) - '1' + 1;
            if ( index == 6 && chk_flag[6] > chk_flag[9] ) {
                chk_flag[9]++;
            } else if (index == 9 && chk_flag[9] > chk_flag[6] ){
                chk_flag[6]++;
            } else {
                chk_flag[index]++;
            }

            if (chk_flag[index] > result) result = chk_flag[index];

        }

        System.out.println(result);

    }

}
