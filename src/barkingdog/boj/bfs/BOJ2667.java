package barkingdog.boj.bfs;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 implements MyStart {

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int [][] board = new int[n][n];

        for (int i=0; i < n; i++) {
            String []inputs = reader.readLine().split("");
            for (int j=0; j < n; j++)
                board[i][j] = Integer.parseInt(inputs[j]);
        }

        int []result = BFS(board, n);
        System.out.println(result.length);
        for (int i=0; i < result.length; i++)
            System.out.println(result[i]);

    }

    int[] BFS(int[][] board, int n) {

        Queue<Integer[]> que = new LinkedList<>();
        Queue<Integer> result_que = new LinkedList<>();

        int []move_x = {-1, 1, 0, 0};
        int []move_y = {0, 0, -1, 1};

        for (int i=0; i < n; i++) {

            for (int j=0; j < n; j++) {

                if (board[i][j] == 1) {

                    int width = 1;

                    que.add(new Integer[]{i, j});
                    board[i][j] = 2;
                    while (!que.isEmpty()) {

                        Integer[] position = que.poll();
                        for (int k=0; k < 4; k++) {

                            int x = position[0] + move_x[k];
                            int y = position[1] + move_y[k];

                            if (x < 0 || y < 0 || x >= n || y >= n)
                                continue;

                            if (board[x][y] != 1)
                                continue;

                            que.add(new Integer[]{x, y});
                            board[x][y] = 2;
                            width++;

                        }

                    }
                    result_que.add(width);

                }

            }

        }

        int max = result_que.size();
        int []isSorted = new int[max];
        for (int i=0; i < max; i++)
            isSorted[i] = result_que.poll();

        Arrays.sort(isSorted);
        return isSorted;

    }

}
