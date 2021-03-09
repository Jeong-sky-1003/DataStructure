package chap04.recursive;

import chap03.stack.IntStack;
import chap04.Chap04;

import java.util.Scanner;

public class Recur3 implements Chap04 {

    private void recur3(int n){

        IntStack stkA = new IntStack(n);
        IntStack stkB = new IntStack(n);

        while (true){

            if ( n > 0 ){
                stkA.push(n);
            }

        }

    }

    @Override
    public void start() {

    }

}
