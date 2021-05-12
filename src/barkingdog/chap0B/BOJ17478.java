package barkingdog.chap0B;

import caseStudy.MyStart;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17478 implements MyStart {

    static int num;
    static final String []texts = {"\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        print(num, builder);

        System.out.println(builder + "\"재귀함수가 뭔가요?\"");
        System.out.println(builder + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        print_final(num, builder);

    }

    void print(int num, StringBuilder builder) {

        if (num <= 0) {
            return;
        } else {

            System.out.println(builder + texts[0]);
            System.out.println(builder + texts[1]);
            System.out.println(builder + texts[2]);
            System.out.println(builder + texts[3]);
            builder.append("____");

            print(num - 1, builder);

        }

    }

    void print_final(int num, StringBuilder builder) {

        if (num <= 0) {
            System.out.println(builder + "라고 답변하였지.");
            return;
        }
        else {
            System.out.println(builder + "라고 답변하였지.");
            builder.delete(builder.length() - 4, builder.length());
            print_final(num - 1, builder);
        }

    }

}
