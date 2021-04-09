package barkingdog.chap03;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3273 implements MyStart {

    @Override
    public void start() throws Exception {
        solve_sky();
    }

    private void solve_sky() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        String []strNums = input.split(" ");

        int result = 0;
        int x = Integer.parseInt(reader.readLine());

        int []nums = new int[num];
        for (int i=0; i < num; i++ ) {
            nums[i] = Integer.parseInt(strNums[i]);
        }

        Arrays.sort(nums);
        int start = 0;
        int end = num-1;
        while (start < end){

            int tmp = nums[start] + nums[end];
            if ( tmp == x ) result++;

            if ( tmp <= x ) start++;
            else end--;

        }

        System.out.println(result);

    }

}
