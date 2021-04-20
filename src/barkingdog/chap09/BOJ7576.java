package barkingdog.chap09;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;

public class BOJ7576 implements MyStart {

    static int [][]tomato;

    @Override
    public void start() throws Exception {
        solve();
    }

    private void solve() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int zero = 0;
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        Queue<Integer[]> que = new LinkedList<>();
        tomato = new int[n][m];
        for (int i=0; i < n; i++) {
            String []nums = reader.readLine().split(" ");
            for (int j=0; j < m; j++) {
                int num = Integer.parseInt(nums[j]);
                if (num == 1) que.add(new Integer[]{i, j});
                if (num == 0) zero++;
                tomato[i][j] = num;
            }
        }

        Integer result = tomato(tomato, que, n, m, zero);
        System.out.println(result);

    }

    void print(int n, int m) {
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++)
                System.out.print(tomato[i][j] + " ");
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    Integer tomato(int [][] tomato, Queue<Integer[]> que, int n, int m, int zero) {

        int flag = 0;
        Integer result = 0;

        final int FINISH = 1;
        final int NOT_YET = 0;
        final int WALL = -1;

        // x: 행, y: 열
        final int []move_x = {-1,1,0,0};
        final int []move_y = {0,0,-1,1};

        Queue<Integer> cnt = new LinkedList<>();
        for (int i=0; i < que.size(); i++)
            cnt.add(0);

        while( !que.isEmpty() ) {

            Integer[] position = que.poll();
            Integer count = cnt.poll();

            for (int i=0; i < 4; i++) {

                int x = position[0] + move_x[i];
                int y = position[1] + move_y[i];

                if (x < 0 || y < 0 || x >= n || y >= m) {
                    continue;
                }
                if (tomato[x][y] != NOT_YET) {
                    continue;
                }

                flag++;
                tomato[x][y] = count+1;
                que.add(new Integer[]{x, y});
                cnt.add(count+1);

            }

            if (!cnt.isEmpty()) result = cnt.peek();

        }

        if (flag != zero) return -1;
        return result;

    }

}
