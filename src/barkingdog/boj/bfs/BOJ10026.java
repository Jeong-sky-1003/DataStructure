package barkingdog.boj.bfs;

import caseStudy.MyStart;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ10026 implements MyStart {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static final int VISITED = 5;

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        int [][]board = new int[num][num];
        for (int i=0; i < num; i++) {

            String []inputs = reader.readLine().split("");
            for (int j=0; j < num; j++) {
                String str = inputs[j];
                if (str.equals("R")) board[i][j] = RED;
                else if (str.equals("G")) board[i][j] = GREEN;
                else if (str.equals("B")) board[i][j] = BLUE;
            }

        }

        BFS(board, num);

    }

    void BFS(int[][] board, int num) {

        // 일반인
        Queue<Integer[]> que = new LinkedList<>();
        // 적록색약
        Queue<Integer[]> color_que = new LinkedList<>();

        int normalCnt = 0;
        int colorCnt = 0;

        int []move_x = {-1, 1, 0, 0};
        int []move_y = {0, 0, -1, 1};

        // 일반인 기준 board
        int [][] copy_board = new int[num][num];
        for (int i=0; i < num; i++) {
            for (int j=0; j < num; j++)
                copy_board[i][j] = board[i][j];
        }

        for (int i=0; i < num; i++) {

            for (int j=0; j < num; j++) {

                int color = board[i][j];
                int copy_color = copy_board[i][j];

                if (copy_board[i][j] != VISITED) {

                    normalCnt++;

                    que.add(new Integer[]{i, j});
                    copy_board[i][j] = VISITED;

                    // 일반인 카운트
                    while ( !que.isEmpty() ) {

                        Integer []position = que.poll();
                        for (int k=0; k < 4; k++) {

                            int x = position[0] + move_x[k];
                            int y = position[1] + move_y[k];

                            if (x < 0 || y < 0 || x >= num || y >= num)
                                continue;
                            if (copy_board[x][y] != copy_color)
                                continue;

                            que.add(new Integer[]{x, y});
                            copy_board[x][y] = VISITED;

                        }

                    }

                }


                if (board[i][j] != VISITED) {

                    colorCnt++;

                    color_que.add(new Integer[]{i, j});
                    board[i][j] = VISITED;

                    while ( !color_que.isEmpty() ){

                        Integer[] position = color_que.poll();
                        for (int k=0; k < 4; k++) {

                            int x = position[0] + move_x[k];
                            int y = position[1] + move_y[k];

                            if (x < 0 || y < 0 || x >= num || y >= num)
                                continue;

                            if ( color <= 1 ) {
                                if ( board[x][y] > 1 ) continue;
                            } else {
                                if (board[x][y] != color) continue;
                            }

                            color_que.add(new Integer[]{x, y});
                            board[x][y] = VISITED;

                        }

                    }

                }

            }

        }
        System.out.printf("%d %d", normalCnt, colorCnt);

    }

}
