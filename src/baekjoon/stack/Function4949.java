package baekjoon.stack;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Function4949 implements MyStart {

    @Override
    public void start() throws Exception {
        run();
    }

    private void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String input = reader.readLine();

            if (input.equals(".")) {
                break;
            }

            input = this.isCorrect(input);
            System.out.println(input);

        }

    }

    private String isCorrect(String s) {

        boolean chk = true;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i < s.length(); i++){

            if ( s.charAt(i) == '(' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
            } else if ( s.charAt(i) == ')' ){
                // pop으로 꺼내어 확인하는데, 이때 맞는 짝이 아니라면 false로 break
                if ( stack.empty() || stack.pop() != '(') {
                    chk = false;
                    break;
                }
            } else if ( s.charAt(i) == ']' ){
                if ( stack.empty() || stack.pop() != '[') {
                    chk = false;
                    break;
                }
            }

        }

        if (!stack.empty()) chk = false;
        return chk? "yes":"no";

    }

}
