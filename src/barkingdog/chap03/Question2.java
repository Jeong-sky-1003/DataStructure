package barkingdog.chap03;

import caseStudy.MyStart;

import java.util.ArrayList;
import java.util.List;

public class Question2 implements MyStart {

    @Override
    public void start() throws Exception {
        System.out.println(func2_solve(new int[]{1, 23, 53, 77, 60}, 5));
    }

    private int func2_solve(int []arr, int n) {
        int []flag = new int[101];
        for (int i=0; i < n; i++) {
            if ( flag[100-arr[i]] == 1 ) return 1;
            flag[arr[i]] = 1;
        }
        return 0;
    }

    private int func2(int []arr, int n) {
        List<Integer> tmp = new ArrayList<>();
        for (int i=0; i < n; i++ ) tmp.add(arr[i]);
        for (int i=0; i<n; i++) {
            int tmpNum = tmp.get(i);
            if ( tmp.contains( 100 - tmpNum ) )
                return 1;
        }
        return 0;
    }

}
