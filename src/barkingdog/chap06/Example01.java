package barkingdog.chap06;

import caseStudy.MyStart;

import java.util.LinkedList;
import java.util.Queue;

public class Example01 implements MyStart {

    @Override
    public void start() throws Exception {
//        MyQueue queue = new MyQueue(5);
        study();
    }

    private void study() {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);                       // add(o): queue 의 rear로 원소를 추가함
        queue.add(2);
        queue.add(3);

        System.out.println(queue.size());   // size( ): queue 원소의 갯수를 반환함
        System.out.println(queue.poll());   // poll( ): 가장 앞에 위치한 원소를 반환하고 삭제함 ( = pop 기능 )
        System.out.println(queue.size());
        System.out.println(queue.peek());   // peek( ): 가장 앞에 위치한 원소를 반환함
        System.out.println(queue.size());
        System.out.println(queue);

    }

}

class MyQueue {

    static int MAX;
    static int[] queue;

    private int head = 0;
    private int tail = 0;

    MyQueue(int capacity) {
        MAX = capacity;
        queue = new int[MAX];
    }

    void push(int number) {
        if (tail >= MAX-1) tail = 0;
        queue[tail++] = number;
    }

    int pop() {
        if (head >= MAX - 1) head = 0;
        return queue[head++];
    }

    int front() {
        if (head == 0) return - 1;
        return queue[head];
    }

    int back() {
        if (tail == 0) return - 1;
        return queue[tail - 1];
    }

}