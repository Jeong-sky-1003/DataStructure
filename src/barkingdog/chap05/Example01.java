package barkingdog.chap05;

import caseStudy.MyStart;

public class Example01 implements MyStart {

    @Override
    public void start() throws Exception {
        MyStack stack = new MyStack();
    }

}

class MyStack {

    int pos = 0;
    int []data = new int[Integer.MAX_VALUE];

    int[] getData() {
        return data;
    }

    int size(){
        return pos;
    }

    void push(int x) {
        data[pos++] = x;
    }

    int pop() {
        return data[pos--];
    }

    int top() {
        return data[pos-1];
    }

}
