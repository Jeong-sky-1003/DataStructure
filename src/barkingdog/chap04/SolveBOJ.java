package barkingdog.chap04;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SolveBOJ implements MyStart {

    @Override
    public void start() throws Exception {
        BOJ1158_Stranger();
    }

    private void BOJ1158_Stranger() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String []input = reader.readLine().split(" ");

        int num = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i <= num; i++)
            numbers.add(i);

        writer.append("<");
        int index = k - 1;

        while ( numbers.size() > 1 ) {

            if (index >= numbers.size())
                index %= numbers.size();

            writer.append(numbers.get(index) + ", ");
            numbers.remove(index);
            index += (k-1);

        }

        writer.append(numbers.get(0) + ">");
        writer.flush();
        writer.close();
        reader.close();

    }

    // BOJ 1158번 요세푸스
    private void BOJ1158() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String []input = reader.readLine().split(" ");

        int num = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int index = -1;
        int count = 0;
        int chk = 0;
        int []flag = new int[num];

        writer.append("<");
        while (true) {

            if (chk == num) break;

            while ( count < k ) {

                index++;

                if (index >= num) {
                    index = 0;
                }

                if ( flag[index] == 0){
                    count++;
                }

            }

            chk++;
            count = 0;
            flag[index] = 1;
            writer.append(String.valueOf(index+1));
            if (chk < num) writer.append(", ");

        }

        writer.append(">");
        writer.flush();
        writer.close();
        reader.close();

    }

    // BOJ 5397번 키로거
    private void BOJ5397() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        int num = Integer.parseInt(reader.readLine());

        for (int i=0; i < num; i++) {

            String str = reader.readLine();

            if ( str.contains("<") || str.contains(">") || str.contains("-") ){

                for (int j=0; j < str.length(); j++) {

                    switch (str.charAt(j)) {

                        case '<' :
                            if (!rightStack.empty()) leftStack.push(rightStack.pop());
                            break;

                        case '>':
                            if (!leftStack.empty()) rightStack.push(leftStack.pop());
                            break;

                        case '-':
                            if (!rightStack.empty()) rightStack.pop();
                            break;

                        default:
                            // 보통 커서가 오른쪽으로 가면서 입력되니 rightStack을 기준으로 함
                            rightStack.push(str.charAt(j));
                            break;

                    }

                }

                while ( !rightStack.empty() )
                    leftStack.push(rightStack.pop());

                while ( !leftStack.empty() )
                    writer.append(leftStack.pop());

            } else {
                writer.append(str);
            }

            writer.append("\n");

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    // BOJ 1406번 에디터
    private void BOJ1406() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = reader.readLine();

        Stack<Character> stk = new Stack<>();
        Stack<Character> result = new Stack<>();

        int num = Integer.parseInt(reader.readLine());

        for (int i=0; i < text.length(); i++)
            stk.push(text.charAt(i));

        for (int i=0; i < num; i++) {

            String []input = reader.readLine().split(" ");

            switch (input[0]) {
                case "L" :
                    // 왼쪽으로 이동하기에 오른쪽 스택에 왼쪽의 데이터 넣기
                    if (!stk.empty()) result.push(stk.pop());
                    break;
                case "D" :
                    // 오른쪽으로 이동하기에 오른쪽 데이터를 왼쪽 스택에 넣기
                    if (!result.empty()) stk.push(result.pop());
                    break;
                case "B" :
                    // 커서를 기준으로 왼쪽 데이터 삭제하기에 왼쪽 데이터를 나타내는 stk 삭제
                    if (!stk.empty()) stk.pop();
                    break;
                case "P" :
                    // 커서를 기준으로 왼쪽에 값을 삽입하기에 왼쪽에 포함되는 stk에 push
                    stk.push(input[1].charAt(0));
                    break;
            }

        }

        while (!stk.empty())
            result.push(stk.pop());

        while (!result.empty())
            writer.append(result.pop());

        writer.flush();
        writer.close();
        reader.close();

    }

}
