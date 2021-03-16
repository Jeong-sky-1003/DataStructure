package inflearn.section2;

import inflearn.Inflearn;

// 인프런 강의
public class Recursion implements Inflearn {

    private void func(int n){
        if(n <= 0) return;
        else {
            func(n-1);
            System.out.printf("hello number %d\n", n);
        }
    }

    private int func_case2(int n){
        if ( n <= 0 ) return 0;
        else {
            return n + func_case2(n-1);
        }
    }

    // factorial
    private int func_factorial(int n){
        if (n < 2) return 1;    // 0! = 1, 1! = 1 : 어차피 1을 두번 곱해야하는데 메모리 낭비를 할 필요가 없어 조건을 이와 같이 함
        else {
            return n * func_factorial(n-1);
        }
    }

    // x의 n승 계산
    private double func_power(double x, int n){
        if (n == 0) return 1;
        else {
            // x의 n승은 x를 n번 곱함. 고로 n의 값으로 곱하는 횟수 제어
            // ex. 2의 3승은 2를 3번 곱함
            return x * func_power(x, n-1);
        }
    }

    // 피보나치 수열
    private int func_fibo(int n){
        if ( n < 2 ) return n;
        else {
            // 공식 fn = n-1 + n-2 ....
            return func_fibo(n-1) + func_fibo(n - 2);
        }
    }

    // 최대공약수 : Euclid
    private int func_euclid(int x, int y){
        if (y == 0) return x;   // base case로 재귀함수의 끝을 지정한다고 보면 됨
        else {
            // 최대공약수는 x >= y 일 때, x와 y의 나머지 값으로 성립함
            return func_euclid(y, x%y);
        }
    }

    @Override
    public void start() {
        //func(5);
        int result = func_fibo(7);
        System.out.printf("result: %d", result);
    }

}


