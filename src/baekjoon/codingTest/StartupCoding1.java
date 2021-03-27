package baekjoon.codingTest;

import baekjoon.BackJoon;

import java.util.HashSet;
import java.util.Set;

public class StartupCoding1 implements BackJoon {

    private int result() {

        Set<Integer> set = new HashSet<Integer>();

        int k = 4;
        int[] numbers = {31, 36, 20, 30, 1, 9, 6, 13, 3,
                29, 11, 25, 7, 8, 2, 24, 34, 18,
                26, 15, 23, 28, 37, 19, 21, 4, 32,
                14, 16, 10, 12, 27, 22, 35, 5, 17, 33};

        int[] numbersCase2 = {7, 3, 1, 8, 4, 6, 2, 5};

        for (int i = 0; i < numbers.length; i++)
            set.add(numbers[i]);

        int num = set.size();
        int result = (num / (k - 1));

        System.out.println(set.size());
        System.out.println(result);

        if ((num % (k - 1)) > 0) result++;

        return result;

    }

    @Override
    public void start() {
        System.out.println(this.result());
    }

}
