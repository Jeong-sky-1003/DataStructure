package baekjoon.stack;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Function10773 implements MyStart {

    @Override
    public void start() throws Exception {
        run();
    }

    private void run() throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i < k; i++ ){

            String input = reader.readLine();
            if (input.equals("0")) stack.remove(stack.size()-1);
            else {
                int num = Integer.parseInt(input);
                stack.push(num);
            }

        }

        k = 0;
        while ( !stack.isEmpty() ){
            k += stack.pop();
        }

        System.out.println(k);

    }

}
