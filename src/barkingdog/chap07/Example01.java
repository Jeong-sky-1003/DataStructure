package barkingdog.chap07;

import caseStudy.MyStart;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Example01 implements MyStart {

    @Override
    public void start() throws Exception {
        stlDeque();
    }

    private void stlDeque() {

        // 자바에서 deque 자료구조는 ArrayDeque를 활용함
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(3);  // addFirst(o): 앞에 추가
        deque.addLast(9);  // addLast(o) : 뒤에 추가
        deque.addFirst(4);
        deque.addLast(10);

        System.out.println(deque);

        System.out.println(deque.peekFirst());  // peekFirst( ): 앞 원소 값 리턴
        System.out.println(deque.pollFirst());  // pollFirst( ): 앞 원소 리턴 후 삭제
        System.out.println(deque.peekLast());   // peekLast( ): 뒤 원소 값 리턴
        System.out.println(deque.pollLast());   // pollLast( ): 뒤 원소 값 리턴 후 삭제

        /*
            출력 결과
            [4, 3, 9, 10]
                4
                4
                10
                10
                3
                3
         */

    }

    private void myDeque() {
        MyDeque deque = new MyDeque(5);
        deque.push_front(52);
        deque.push_front(33);
        deque.push_back(15);
        deque.push_back(22);
        System.out.println(deque.pop_front());
        System.out.println(deque.pop_front());
        System.out.println(deque.pop_back());
        System.out.println(deque.pop_back());
    }

}

class MyDeque {

    static int MAX;
    static int []deque;
    private static int head;
    private static int tail;

    MyDeque(int capacity) {
        MyDeque.MAX = capacity;
        MyDeque.head = MAX;
        MyDeque.tail = MAX;
        MyDeque.deque = new int[MAX * 2 + 1];
    }

    void push_front(int num) {
        deque[--head] = num;
    }

    void push_back(int num) {
        deque[tail++] = num;
    }

    int pop_front() {
        if (head == MAX) return -1;
        return deque[head++];
    }

    int pop_back() {
        if (tail == MAX) return -1;
        return deque[--tail];
    }

    int front() {
        if (head == MAX) return -1;
        return deque[head];
    }

    int back() {
        if (tail == MAX) return -1;
        return deque[tail];
    }

}