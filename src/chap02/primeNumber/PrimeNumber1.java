package chap02.primeNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber1 implements PrimeNumber{

    private Scanner sc;

    public PrimeNumber1(){
        sc = new Scanner(System.in);
    }

    @Override
    public void start(){

        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        int counter = 0;

        for (int i = 3; i <= 100; i+=2){

            boolean chk = true;

            for (Integer element:primes){
                counter++;

                if (i%element == 0){
                    chk = false;
                    break;
                }

            }

            if (chk)
                primes.add(i);

        }

        for (Integer element:primes){
            System.out.println(element);
        }

        System.out.println("실행 횟수: " + counter);

    }

}
