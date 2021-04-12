package barkingdog.chap07;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Deque;
import java.util.ArrayDeque;

public class SolveBOJ implements MyStart {

    @Override
    public void start() throws Exception {
        BOJ10866();
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
