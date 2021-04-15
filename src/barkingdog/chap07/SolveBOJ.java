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
        Stack<Character> stk = new Stack<>();
        int index = stk.search('e');

        String t = "eeeeee";
        System.out.println(t.contains("e"));

        int in = t.indexOf("e");
        t = t.substring(0, in) + t.substring(in+1);

        System.out.println(in);
        System.out.println(t);
        System.out.println(t.length());
        System.out.println("------------");

        List<String> tt = new ArrayList<>();
        tt.add("e");
        System.out.println(tt.get(0));
        tt.remove("e");
        for (String e:tt)
            System.out.println(e);

        BOJ5430_2();
    }

    private void BOJ5430_2() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i=0; i < num; i++) {

            Deque<Integer> deq = new LinkedList<>();

            String function = reader.readLine();
            int arrNum = Integer.parseInt(reader.readLine());

            String inputs = reader.readLine();
            inputs = inputs.substring(1, inputs.length()-1);
            String []nums = inputs.split(",");

            if (arrNum > 0) {
                for (int j = 0; j < arrNum; j++)
                    deq.addLast(Integer.parseInt(nums[j]));
            }

            result.append(AC(deq, function)).append("\n");

        }

        System.out.println(result);

    }

    private String AC(Deque<Integer> deq, String function) {

        boolean reverse = false;
        StringBuilder builder = new StringBuilder();
        for (int i=0; i < function.length(); i++) {

            if (function.charAt(i) == 'R')
                reverse = !reverse;
            else {
                if (deq.isEmpty())
                    return "error";
                if (reverse) deq.pollLast();
                else deq.pollFirst();
            }

        }

        builder.append("[");
        while (!deq.isEmpty()) {

            if (reverse) builder.append(deq.pollLast());
            else builder.append(deq.pollFirst());

            if (deq.size() > 0) builder.append(",");

        }
        builder.append("]");
        return builder.toString();

    }

    // BOJ 5430: AC
    private void BOJ5430() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());

        for (int i=0; i < t; i++) {

            String function = reader.readLine();
            LinkedList<Integer> numbers = new LinkedList<>();

            boolean reverseChk = false;
            int num = Integer.parseInt(reader.readLine());

            String nums = reader.readLine();
            nums = nums.substring(1, nums.length()-1);
            String[] arr = nums.split(",");

            boolean chk = true;
            if (num > 0) {
                for (int k=0; k < num; k++)
                    numbers.addLast(Integer.parseInt(arr[k]));
            }

            for (int j=0; j < function.length(); j++){
                if (function.charAt(j) == 'R')
                    reverseChk = !reverseChk;
                else {
                    if (numbers.isEmpty()){
                        chk = false;
                        break;
                    }
                    if (reverseChk)
                        numbers.pollLast();
                    else
                        numbers.pollFirst();
                }
            }

            if(chk) {
                builder.append("[");
                if (reverseChk) {
                    builder.append(numbers.pollLast());
                    while (!numbers.isEmpty())
                        builder.append(",").append(numbers.pollLast());
                    builder.append("]");
                } else {
                    builder.append(numbers.pollFirst());
                    while (numbers.size() > 1)
                        builder.append(",").append(numbers.pollFirst());
                    builder.append("]");
                }
            } else {
                builder.append("error");
            }
            builder.append("\n");
        }
        System.out.println(builder);

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
