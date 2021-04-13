package barkingdog.chap07;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.*;

public class SolveBOJ implements MyStart {

    @Override
    public void start() throws Exception {
        BOJ1021();
    }

    // BOJ 1021: 회전하는 큐
    private void BOJ1021() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int result = 0;
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        inputs = reader.readLine().split(" ");

        // deque는 LinkedList로 구현하는 것이 좋을듯 함
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i=1; i <= n; i++)
            deque.add(i);

        for (int i=1; i <= m; i++) {

            int num = Integer.parseInt(inputs[i-1]);
            int index = deque.indexOf(num);

            int mid = deque.size() % 2;
            if (mid == 0) mid = deque.size()/2 - 1;
            else mid = (deque.size()/2);

            if ( index <= mid ) {
                while ( deque.peekFirst() != num ) {
                    result++;
                    deque.addLast(deque.pollFirst());
                }
            } else {
                while ( deque.peekFirst() != num ) {
                    result++;
                    deque.addFirst(deque.pollLast());
                }
            }

            deque.pollFirst();

        }

        System.out.println(result);

    }

    // BOJ 10866: 덱 (제한시간 0.5초)
    private void BOJ10866() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(reader.readLine());
        Deque<Integer> deq = new ArrayDeque<>();

        for (int i=0; i < num; i++) {

            String []input = reader.readLine().split(" ");

            if ( input[0].contains("push") ) {

                if (input[0].contains("back"))
                    deq.addLast(Integer.parseInt(input[1]));
                else if (input[0].contains("front"))
                    deq.addFirst(Integer.parseInt(input[1]));

            } else if ( input[0].contains("pop") ) {

                if (deq.isEmpty()) {
                    writer.append(-1 + "\n");
                    continue;
                }

                if (input[0].contains("back"))
                    writer.append(deq.pollLast() + "\n");
                else if (input[0].contains("front"))
                    writer.append(deq.pollFirst() + "\n");

            } else {

                switch (input[0]) {

                    case "size":
                        writer.append(deq.size() + "\n");
                        break;
                    case "empty":
                        if (deq.isEmpty()) writer.append(1 + "\n");
                        else writer.append(0 + "\n");
                        break;
                    case "front":
                        if (deq.isEmpty()) writer.append(-1 + "\n");
                        else writer.append(deq.getFirst() + "\n");
                        break;
                    case "back":
                        if (deq.isEmpty()) writer.append(-1 + "\n");
                        else writer.append(deq.getLast() + "\n");
                        break;

                }

            }

        }

        writer.flush();
        writer.close();
        reader.close();

    }

}
