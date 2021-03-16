package baekjoon.function;

import baekjoon.BackJoon;
import inflearn.Inflearn;

import java.sql.PreparedStatement;
import java.util.*;

public class Function4673 implements BackJoon {

    Stack<Integer> stack = new Stack<>();
    static HashSet<Integer> set_result = new HashSet<>();

    private int func_d_ver2(int num){

        String num_str = String.valueOf(num);
        char []num_list = num_str.toCharArray();

        int tmpSum = 0;
        for (int i=0; i < num_list.length; i++)
            tmpSum += Character.getNumericValue(num_list[i]);

        return num + tmpSum;

    }

    private static int getNum(int n, int k){
        if (n < 1) return 1;
        else {
            return 10 * getNum(n-1, 10);
        }
    }

    private static int func_d(int n, int k, int len){
        int sum = n;
        for (int i=0; i < len; i++){
            sum += ( n / k);
            n %= k;
            k /= 10;
        }
        return sum;
    }

    private static void getSelfNumber(int num){

        for (int i=0; i < num; i++){

            int len = String.valueOf(i).length();
            // 자리수 계산
            int k = getNum(len-1, 10);
            // 각 숫자 계산
            int result = func_d(i, k, len);
            set_result.add(result);

            if ( !set_result.contains(i) ){
                System.out.println(i);
            }

        }

    }

    @Override
    public void start() {
        getSelfNumber(10000);
    }

}
