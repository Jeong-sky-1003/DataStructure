package barkingdog.chap0B;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11729 implements MyStart {

    static int count = 0;
    static StringBuilder builder;

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();

        int num = Integer.parseInt(reader.readLine());

        move(num, 1, 2, 3);
        System.out.printf("%d\n", count);
        System.out.println(builder);

    }

    /*
        풀이
        1. 함수 정의
            - 원판 num개를 from 기둥에서 to 기둥으로 옮기는 방법을 출력할 함수
            - num 을 매개변수로 받아 Base Condition 을 명시함
        2. Base Condition
            - n이 1일 때, a를 b로 옮김
        3. 재귀 식
            - n-1개 원판을 from에서 goal로 옮김
            - n번 원판을 기둥 from에서 to로 옮김
            - n-1개의 원판을 to에서 from로 옮김
     */
    private void move(int num, int from, int to, int goal) {

        count++;
        if (num == 1) {
            builder.append(from + " " + goal + "\n");
            return;
        }

        move(num - 1, from, goal, to);
        builder.append(from + " " + goal + "\n");
        move(num - 1, to, from, goal);

    }


}
