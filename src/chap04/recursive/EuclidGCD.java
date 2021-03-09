package chap04.recursive;

import chap04.Chap04;

import java.util.Scanner;

public class EuclidGCD implements Chap04 {

    private Scanner sc;

    public EuclidGCD(){
        sc = new Scanner(System.in);
    }

    private int gcd(int x, int y){
        if (y == 0){
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    private int gcdVer2(int x, int y){
        while (y != 0){
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return (x);
    }

    @Override
    public void start() {

        System.out.print("정수 입력: ");
        int x = sc.nextInt();

        System.out.print("정수 입력: ");
        int y = sc.nextInt();

        System.out.printf("%d와 %d의 최대공약수: %d", x, y, gcdVer2(x,y));

    }

}
