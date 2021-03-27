package baekjoon.stack;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Function10828 implements MyStart {

    public void run() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {

            String input = reader.readLine();

            if (input.contains("push")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                stack.push(number);
            } else {

                switch (input) {
                    case "pop":
                        if (stack.empty()) System.out.println(-1);
                        else System.out.println(stack.pop());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.empty() ? 1 : 0);
                        break;
                    case "top":
                        if (stack.empty()) System.out.println(-1);
                        else System.out.println(stack.peek());
                        break;
                }

            }

        }

    }

    @Override
    public void start() throws Exception {
        run();
    }

}
