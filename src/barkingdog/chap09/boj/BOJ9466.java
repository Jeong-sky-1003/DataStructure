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

            writer.append(BFS(students, student) + "\n");
            System.out.println();

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    int BFS(int[] students, int num) throws Exception{

        int count = 0;

        for (int i=1; i <= num; i++) {

            Stack<Integer> point_stk = new Stack<>();
            Queue<Integer> stu_que = new LinkedList<>();

            int tmp = i;
            int index = students[i];
            while (true) {

                System.out.println("---------------------");
                stu_que.add(tmp);
                point_stk.push(index);

                if (tmp == index && point_stk.peek() != stu_que.peek()) {
                    System.out.println("count point");
                    count++;
                    break;
                }

                if ( (index != tmp && point_stk.peek() == stu_que.peek()) || (tmp == index) ) {
                    break;
                }

                tmp = index;
                index = students[index];
                System.out.println(stu_que);
                System.out.println(point_stk);

                Thread.sleep(8000);

            }

        }

        return count;

    }

}
