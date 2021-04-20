package barkingdog.chap08;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Example01 implements MyStart {


    private static Stack<String> stk = new Stack<>();

    @Override
    public void start() throws Exception {
        BOJ2504();
    }

    // https://github.com/hotehrud/acmicpc/blob/master/algorithm/stack/2504.java
    // c1은 짝이 맞지 않는 경우이며, c2는 짝이 맞는 경우로
    // 이는 메서드를 호출하는 곳에셔 매게변수로 넘겨줌
    private int calLoop(Stack<String> stk, String c1, String c2, int val) throws Exception{

        int result = 0;
        while (!stk.isEmpty()) {
            String pop = stk.peek();
            // 예외처리. 괄호가 맞지 않는 경우
            if (pop.equals(c1)) return -1;
            else if (pop.equals(c2)) {
                stk.pop();
                result *= val;
                stk.push(String.valueOf(result));
                break;
            } else {
                int num = Integer.parseInt(stk.pop());
                result += num;
            }
        }

        return result;

    }

    private void BOJ2504() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int chk = 0;
        int result = 0;

        for (int i=0; i < input.length(); i++) {

            if (chk == -1) {
                result = 0;
                break;
            }

            String str = String.valueOf(input.charAt(i));

            if (str.equals("(") || str.equals("[")) {
                stk.push(str);
            } else {

                if (str.equals(")") ) {

                    if (stk.isEmpty()) {
                        chk = -1;
                        result = 0;
                        break;
                    }

                    if (stk.peek().equals("(")) {
                        stk.pop();
                        stk.push("2");
                    } else {
                        // 만약 스택의 top 값이 숫자인 경우
                        chk = calLoop(stk, "[", "(", 2);
                    }

                } else if (str.equals("]")) {

                    if (stk.isEmpty()) {
                        chk = -1;
                        result = 0;
                        break;
                    }

                    if (stk.peek().equals("[")) {
                        stk.pop();
                        stk.push("3");
                     } else {
                        // 만약 스택의 top 값이 숫자일 경우인듯함
                        chk = calLoop(stk, "(", "[", 3);
                    }

                }

            }

        }

        if (chk >= 0) {
            while (!stk.isEmpty()) {
                int num = Integer.parseInt(stk.pop());
                result += num;
            }
        }

        System.out.println(result);

    }

    private void BOJ10799() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Stack<Character> stk = new Stack<>();
        int result = 0;

        for(int i=0; i < input.length(); i++) {

            if (input.charAt(i) == '(') stk.push('(');
            else {
                stk.pop();
                if (input.charAt(i-1) == ')')
                    result++;
                if ( input.charAt(i-1) == '(' )
                    result += stk.size();
            }

        }

        System.out.println(result);

    }

    private void BOJ4949() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {

            Stack<Character> stk = new Stack<>();
            boolean chk = true;

            String input = reader.readLine();
            if (input.equals(".")) break;

            for (int i=0; i < input.length(); i++) {

                if (!chk) break;

                if ( input.charAt(i) == '(' || input.charAt(i) == '[' ) {
                    stk.push(input.charAt(i));
                } else if (input.charAt(i) == ')' || input.charAt(i) == ']'){

                    if ( input.charAt(i) == ')' ) {
                        if (stk.isEmpty()) chk = false;
                        else if ( stk.peek() == '(' ) stk.pop();
                        else chk = false;
                    } else if ( input.charAt(i) == ']' ) {
                        if (stk.isEmpty()) chk = false;
                        else if ( stk.peek() == '[' ) stk.pop();
                        else chk = false;
                    }

                }

                System.out.println(stk);

            }

            if (stk.isEmpty() && chk) sb.append("yes\n");
            else sb.append("no\n");

        }

        System.out.println(sb.toString());

    }

}
