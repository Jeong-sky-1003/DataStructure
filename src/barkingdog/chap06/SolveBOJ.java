package barkingdog.chap06;

import caseStudy.MyStart;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SolveBOJ implements MyStart {

    @Override
    public void start() throws Exception {
        BOJ2164();
    }

    // BOJ 2164: 카드 2
    private void BOJ2164() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        Queue<Integer> que = new LinkedList<>();

        for (int i=1; i <= num; i++) que.add(i);

        while (que.size() > 1) {
            que.poll();
            que.add(que.poll());
        }

        System.out.println(que.peek());

    }

    // BOJ 18258: 큐 2
    private void BOJ18258() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(reader.readLine());
        int last = 0;
        Queue<Integer> que = new LinkedList<>();

        for (int i=0; i < num; i++) {

            String []input = reader.readLine().split(" ");
            if (input[0].equals("push")) {
                last = Integer.parseInt(input[1]);
                que.add(last);
            } else {

                switch(input[0]) {
                    case "pop":
                        if (que.isEmpty()) writer.append(-1 + "\n");
                        else writer.append(que.poll() + "\n");
                        break;
                    case "size":
                        writer.append(que.size() + "\n");
                        break;
                    case "empty":
                        if (que.isEmpty()) writer.append(1 + "\n");
                        else writer.append(0 + "\n");
                        break;
                    case "front":
                        if (que.isEmpty()) writer.append(-1 + "\n");
                        else writer.append(que.peek() + "\n");
                        break;
                    case "back":
                        if (que.isEmpty()) writer.append(-1 + "\n");
                        else writer.append(last + "\n");
                        break;
                }

            }

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    // BOJ 10845: 큐
    private void BOJ10845() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i=0; i < num; i++) {

            String []input = reader.readLine().split(" ");
            if (input[0].equals("push")) {
                int number = Integer.parseInt(input[1]);
                queue.add(number);
                last = number;
            } else {

                switch (input[0]) {
                    case "pop":
                        if (queue.isEmpty()) System.out.println(-1);
                        else System.out.println(queue.poll());
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    case "empty":
                        if (queue.isEmpty()) System.out.println(1);
                        else System.out.println(0);
                        break;
                    case "front":
                        if (queue.isEmpty()) System.out.println(-1);
                        else System.out.println(queue.peek());
                        break;
                    case "back":
                        if (queue.isEmpty()) System.out.println(-1);
                        else System.out.println(last);
                        break;

                }

            }

        }

    }

}
