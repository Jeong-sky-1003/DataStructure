package barkingdog.chap01;

import caseStudy.MyStart;

public class FirstCase implements MyStart{

    @Override
    public void start() throws Exception {
        int []arr = new int[5];
        System.out.println(func1(arr, arr.length));
    }

    private int func1(int arr[], int n) {

        int cnt = 0;
        for (int i=0; i < n; i++ )
            if (arr[i] % 5 == 0) cnt++;

        return cnt;

    }

}
