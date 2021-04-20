package barkingdog.chap09;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;

public class BOJ2178 implements MyStart {

    static int [][]board;

    @Override
    public void start() throws Exception {
        solve();
    }

    void solve() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        board = new int[n--][m--];
        for (int i=0; i <= n; i++) {
            String []numbers = reader.readLine().split("");
            for (int j=0; j <= m; j++)
                board[i][j] = Integer.parseInt(numbers[j]);
        }

        int result = move(board, n, m);
        System.out.println(result);

    }

    void print(int n, int m) {
        for (int i=0; i <= n; i++) {
            for (int j=0; j <= m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    int move(int[][] board, int n, int m) {

        final int MOVE = 2;
        final int NOT_YET = 1;
        final int WALL = 0;

        // x: 행 y: 열
        int []move_x = {-1, 1, 0, 0};
        int []move_y = {0, 0, -1, 1};

        Queue<Integer[]> positions = new LinkedList<>();
        Queue<Integer> count = new LinkedList<> ();

        board[0][0] = MOVE;

        positions.add(new Integer[]{0, 0});
        count.add(1);

        while(!positions.isEmpty()) {

            Integer cnt = count.poll();
            Integer []position = positions.poll();
            for (int i=0; i < 4; i++) {

                int x = position[0] + move_x[i];
                int y = position[1] + move_y[i];

                if (x < 0 || y < 0 || x > n || y > m)
                    continue;

                if (board[x][y] != NOT_YET)
                    continue;

                if (x == n && y == m) return ++cnt;

                board[x][y] = MOVE;
                positions.add(new Integer[]{x, y});
                count.add(cnt+1);

            }

        }

        return 0;

    }

}
