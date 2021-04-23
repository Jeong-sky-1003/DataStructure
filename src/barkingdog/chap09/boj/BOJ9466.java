package barkingdog.chap09.boj;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 깊이 우선 탐색 학습 후 재시도
public class BOJ9466 implements MyStart {

    @Override
    public void start() throws Exception {
        solve();
    }

    private void solve() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());

        for (int i=0; i < t; i++) {

            int student = Integer.parseInt(reader.readLine());
            int []students = new int[student + 1];

            String []inputs = reader.readLine().split(" ");
            for (int j=0; j < student; j++) {
                int num = Integer.parseInt(inputs[j]);
                students[j+1] = num;
            }

            int result = 0;
            int []arr = BFS(students, student);
            for (int j=1; j <= student; j++) {
                if (arr[j] <= 0) result++;
            }
            writer.append(result + "\n");

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    int[] BFS(int[] students, int num) throws Exception{

        Queue<Integer> s_que = new LinkedList<>();
        Stack<Integer> i_stk = new Stack<>();
        int []arr = new int[num+1];

        for (int i=1; i <= num; i++) {

            // 1
            s_que.add(i);
            // 3
            i_stk.push(students[i]);
//            System.out.println(s_que);

            while ( !i_stk.isEmpty() ) {

                // 3
                int number = i_stk.pop();

                if ( arr[number] == 0 ) {
                    arr[number] = 1;
                    s_que.add(number);
                    i_stk.push(students[number]);
                } else {

                    if (arr[number] == 1 && arr[s_que.peek()] == 1) {
                        s_que.clear();
                        i_stk.clear();
                        break;
                    } else if ( arr[number] == -1 ) {
                        arr[s_que.poll()] = -1;
                        s_que.clear();
                        i_stk.clear();
                        break;
                    } else if ( s_que.peek() != number ) {
                        arr[s_que.poll()] = -1;
                        s_que.clear();
                        i_stk.clear();
                        break;
                    }

                }

//                for (int j=1; j <= num; j++)
//                    System.out.printf("%2d", arr[j]);
//                System.out.println();

            }

//            for (int j=1; j <= num; j++)
//                System.out.printf("%2d", arr[j]);
//            System.out.println();

        }

        return arr;

    }

}
