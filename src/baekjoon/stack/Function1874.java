package baekjoon.stack;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Function1874 implements MyStart {

    @Override
    public void start() throws Exception {
        run();
    }

    private void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        int number = Integer.parseInt(reader.readLine());

        Stack<Integer> number_stack = new Stack<>();
        List<String> result = new ArrayList<>();

        while (true) {

            int input = Integer.parseInt(reader.readLine());

            if (num < input) {

                while (input != num) {
                    number_stack.push(++num);
                    result.add("+");
                }

            }

            if ( input == number_stack.pop())
                result.add("-");
            else {
                System.out.println("NO");
                return;
            }

            if ( number_stack.empty() && number <= num ) break;

        }

        for (String e : result){
            System.out.println(e);
        }

    }

}