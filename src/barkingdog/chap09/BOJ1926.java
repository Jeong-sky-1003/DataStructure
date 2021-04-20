package barkingdog.chap09;

import caseStudy.MyStart;

import java.util.LinkedList;
import java.util.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1926 implements MyStart {

    static int [][]board;

    @Override
    public void start() throws Exception {
        solve();
    }

    private void solve() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int []result;

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        board = new int[n][m];
        for (int i=0; i < n; i++) {
            String []nums = reader.readLine().split(" ");
            for (int j=0; j < m; j++) {
                int num = Integer.parseInt(nums[j]);
                board[i][j] = num;
            }
        }

        result = countPaint(board, n, m);
        System.out.printf("%d\n%d", result[0], result[1]);

    }

    private int[] countPaint(int[][] board, int n, int m) {

        int []result = new int[2];

        final int CHECK = 2;
        final int NOT_YET = 1;
        final int WALL = 0;

        // 상하좌우
        final int []move_x = {-1, 1, 0, 0}; // 행
        final int []move_y = {0, 0, -1, 1}; // 열

        Queue<Integer[]> que = new LinkedList<>();

        for (int i=0; i < n; i++ ) {

            for (int j=0; j < m; j++) {

                if (board[i][j] == NOT_YET) {

                    que.add(new Integer[]{i, j});
                    board[i][j] = CHECK;

                    int tmpWidth = 1;
                    while ( !que.isEmpty() ) {

                        Integer []point = que.poll();
                        for (int k=0; k < 4; k++) {

                            int x = point[0] + move_x[k];
                            int y = point[1] + move_y[k];

                            if (x < 0 || y < 0 || x >= n || y >= m)
                                continue;
                            if (board[x][y] != NOT_YET)
                                continue;

                            que.add(new Integer[]{x, y});
                            board[x][y] = CHECK;
                            tmpWidth++;

                        }

                    }

                    if (result[1] < tmpWidth) result[1] = tmpWidth;
                    ++result[0];

                }

            }

        }

        return result;

    }

}
