package barkingdog.chap08;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Example01 implements MyStart {

    @Override
    public void start() throws Exception {
        BOJ2504();
    }

    private void BOJ2504() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Stack<Character> stk = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        int result = 0;
        input = input.replace("()", "2");
        input = input.replace("[]", "3");
        System.out.println(input);

        for (int i=0; i < input.length(); i++) {

            if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                stk.push(input.charAt(i));
            } else {

                if (input.charAt(i) == ')') {

                    if (stk.peek() == '(') {

                        if ( stk.size() > 1 ) {
                            nums.push(nums.pop() * 2);
                            stk.pop();
                        } else {
                            stk.pop();
                            int tmp = 0;
                            while ( !nums.isEmpty() )
                                tmp += nums.pop();
                            System.out.println( result + ", " + tmp);
                            result = result + (tmp * 2);
                        }

                    }

                } else if (input.charAt(i) == ']') {

                    if (stk.peek() == '[') {

                        if ( stk.size() > 1 ) {
                            nums.push(nums.pop() * 3);
                            stk.pop();
                        } else {
                            stk.pop();
                            int tmp = 0;
                            while ( !nums.isEmpty() )
                                tmp += nums.pop();
                            System.out.println( result + ", " + tmp);
                            result = result + (tmp * 3);
                        }

                    }


                } else {
                    int num = input.charAt(i) - '0';
                    if ( stk.isEmpty() ) result += num;
                    else nums.push(num);
                }

            }
            System.out.println(stk);
            System.out.println(nums);
            System.out.println("result: " + result);

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
