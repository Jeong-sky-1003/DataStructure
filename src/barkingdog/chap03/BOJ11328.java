package barkingdog.chap03;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11328 implements MyStart {

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        for (int i=0; i < num; i++ ){

            String []str = reader.readLine().split(" ");

            if ( strfry(str[0], str[1]) ) System.out.println("Possible");
            else System.out.println("Impossible");

        }

    }

    // 입력된 문자열을 무작위로 재배열함
    // 입력된 문자열과 재배열한 문자열이 서로 다를 필요는 없음
    // 입력된 문자열에 대해 첫 번째 문자열이 strfry를 적용해 얻을 수 있는 것인지 판단하라.
    private boolean strfry(String str1, String str2) {

        int num = str1.length();

        char []str1_char = str1.toCharArray();
        char []str2_char = str2.toCharArray();

        Arrays.sort(str1_char);
        Arrays.sort(str2_char);

        for (int i=0; i < num ; i++ ) {
            if ( str1_char[i] != str2_char[i] ) return false;
        }
        return true;

    }

}
