package chap04.recursive;

import chap04.Chap04;

import java.util.Scanner;

public class Factorial implements Chap04 {

    private Scanner sc;

    public Factorial(){
        sc = new Scanner(System.in);
    }

    private int factorial(int n){

        if(n > 0){
            return n * factorial(n - 1);
        } else {
            return 1;
        }

    }

    private int factorialVer2(int n){
        int result = n;
        if (n > 0){
            for (int i = 1; i < n; i++){
                result = result * (n - i);
            }
            return result;
        } else {
            return 1;
        }
    }

    @Override
    public void start() {

        System.out.print("정수 입력: ");
        int x = sc.nextInt();
        int result = factorialVer2(x);

        System.out.printf("%d! = %d", x, result);

    }

}
