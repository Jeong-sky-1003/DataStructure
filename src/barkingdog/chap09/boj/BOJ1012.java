package barkingdog.chap09.boj;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Queue;
import java.util.LinkedList;

public class BOJ1012 implements MyStart {

    final int BUG = 1;
    final int VISITED = 2;

    BufferedReader reader;
    BufferedWriter writer;

    @Override
    public void start() throws Exception {
        solve();
    }

    void solve() throws Exception {

        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(reader.readLine());

        for (int i=0; i < total; i++) {

            String []inputs = reader.readLine().split(" ");

            int row = Integer.parseInt(inputs[1]);
            int column = Integer.parseInt(inputs[0]);
            int count = Integer.parseInt(inputs[2]);

            int[][] board = cal(row, column, count);
            int result = BFS(board, row, column);
            writer.append(result + "\n");

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    int[][] cal(int row, int column, int count) throws Exception {

        int [][]board = new int[row][column];

        for (int i=0; i < count; i++) {

            String []inputs = reader.readLine().split(" ");

            int x = Integer.parseInt(inputs[1]);
            int y = Integer.parseInt(inputs[0]);

            board[x][y] = BUG;
        }

        return board;

    }

    int BFS(int[][] board, int row, int column) {

        int result = 0;

        Queue<Integer[]> que = new LinkedList<>();

        int []move_x = {-1, 1, 0, 0};
        int []move_y = {0, 0, -1, 1};

        for (int i=0; i < row; i++) {

            for (int j=0; j < column; j++) {

                if (board[i][j] == BUG) {

                    que.add(new Integer[]{i, j});
                    board[i][j] = VISITED;

                    while( !que.isEmpty() ) {

                        Integer[] position = que.poll();
                        for (int k=0; k < 4; k++) {

                            int x = position[0] + move_x[k];
                            int y = position[1] + move_y[k];

                            if (x < 0 || y < 0 || x >= row || y >= column)
                                continue;
                            if (board[x][y] != BUG)
                                continue;

                            que.add(new Integer[]{x, y});
                            board[x][y] = VISITED;

                        }

                    }
                    result++;

                }

            }

        }

        return result;

    }

    void print(int [][]arr) {
        for (int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[0].length; j++)
                System.out.printf("%2d", arr[i][j]);
            System.out.println("");
        }
        System.out.println("-------------------------------------");
    }

}
