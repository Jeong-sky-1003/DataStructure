package barkingdog.chap09;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;

public class BOJ1697 implements MyStart {

    @Override
    public void start() throws Exception {
        solve();
    }

    /*
        내 개선점!
        입력될 수 있는 최대 값을 잘 활용할 것!
        계산하게 될 경우 만든 배열의 범위를 넘어갈 수 있다는 사실을 인지하고 배열의 크기를 결정할 것!
     */
    void solve() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int []arr = new int[100001];

        Integer result = find(n, k, arr);
        System.out.println(result);

    }

    Integer find(int n, int k, int []arr) {

        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        arr[n] = 1;

        while (true) {

            int num = que.poll();
            int cnt = arr[num];

            if (arr[k] != 0)
                return arr[k]-1;

            if ( num-1 >= 0 && arr[num-1] == 0 ) {
                que.add(num-1);
                arr[num-1] = cnt+1;
            }
            if ( num+1 <= 100000 && arr[num+1] == 0 ) {
                que.add(num+1);
                arr[num+1] = cnt+1;
            }
            if ( num*2 <= 100000 && arr[num*2] == 0 ) {
                que.add(num*2);
                arr[num*2] = cnt+1;
            }

        }

    }

}
