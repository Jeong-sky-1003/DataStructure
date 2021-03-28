package baekjoon.stack;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Function9012 implements MyStart {

    @Override
    public void start() throws Exception {
        run2();
    }

    private void run2() throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        for (int i=0; i < number; i++ ){

            String input = reader.readLine();
            int num = 0;
            for (int j=0; j < input.length(); j++){
                if ( input.charAt(j) == '(' ) num += 1;
                else num += -1;
            }

            System.out.println( (num==0)? "YES":"NO" );

        }

    }

    private void run() throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        Stack<String> result_stack = new Stack<>();

        for (int i=0; i < number; i++ ) {

            Stack<Character> ps_stack = new Stack<>();
            String input = reader.readLine();

            for (int j=0; j < input.length(); j++ ){

                if ( input.charAt(j) == ')' && ps_stack.empty() ){
                    ps_stack.push('t');
                    break;
                }

                if ( input.charAt(j) == '(' ){
                    ps_stack.push('(');
                } else if ( input.charAt(j) == ')' ){
                    ps_stack.remove( ps_stack.size()-1 );
                }

            }

            if ( ps_stack.empty() ) {
                result_stack.push("YES");
            }
            else {
                result_stack.push("NO");
            }

        }

        for (int i=0; i < result_stack.size(); i++)
            System.out.println(result_stack.get(i));

    }

}
