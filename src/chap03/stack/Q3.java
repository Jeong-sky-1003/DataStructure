package chap03.stack;

import chap03.Chapter03;

public class Q3 implements Chapter03 {

    private int max;
    private int ptrA;
    private int ptrB;
    private int[] stk;

    private enum Stack{ stackA, stackB }

    public Q3(int capacity){

        max = capacity;
        ptrA = 0;
        ptrB = max - 1;

        try {
            stk = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }

    }

    public static class EmptyStackException extends RuntimeException{
        public EmptyStackException() {}
    }

    public static class OverFlowStackException extends RuntimeException{
        public OverFlowStackException() {}
    }

    public int push(Stack st, int x) throws OverFlowStackException{

        if ( ptrA >= ptrB + 1 )
            throw new OverFlowStackException();

        switch (st){
            case stackA:
                stk[ptrA++] = x;
                break;
            case stackB:
                stk[ptrB--] = x;
                break;
        }

        return x;

    }

    @Override
    public void start() {


    }

}
