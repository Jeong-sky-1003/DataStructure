package chap02.primeNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber2 implements PrimeNumber {

    private Scanner sc;

    public PrimeNumber2() {
        sc = new Scanner(System.in);
    }

    @Override
    public void start() {

        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        System.out.println("---------" + primes.get(1));

        int counter = 0;

        for (int i = 3; i <= 100; i += 2) {

            boolean chk = true;

            for (int j = 1; primes.get(j) * primes.get(j) <= i; j++) {
                counter = counter + 2;
                if (i % primes.get(j) == 0) {
                    chk = false;
                    break;
                }

            }

            if (chk) {
                primes.add(i);
                counter++;
            }

        }

        for (Integer element : primes) {
            System.out.println(element);
        }

        System.out.println("실행 횟수: " + counter);

    }

}
