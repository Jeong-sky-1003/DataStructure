package barkingdog.chap09.boj;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2583 implements MyStart {

    final int CHK = 2;
    final int BOX = 1;
    final int REMAIN = 0;

    @Override
    public void start() throws Exception {
        solve();
    }

    private void solve() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int row = Integer.parseInt(inputs[0]);
        int column = Integer.parseInt(inputs[1]);
        int box = Integer.parseInt(inputs[2]);

        int [][]board = new int [row][column];
        for (int i=0; i < box; i++) {

            inputs = reader.readLine().split(" ");

            int x1 = row - Integer.parseInt(inputs[1]);
            int y1 = Integer.parseInt(inputs[0]);
            int x2 = row - Integer.parseInt(inputs[3]);
            int y2 = Integer.parseInt(inputs[2]);

            for (int x = x2; x < x1; x++) {
                for (int y = y1; y < y2; y++)
                    board[x][y] = BOX;
            }

        }

        Queue<Integer> result = BFS(board, row, column);
        System.out.println(result.poll());
        while (!result.isEmpty())
            System.out.printf("%d ", result.poll());

    }

    Queue<Integer> BFS(int[][] board, int row, int column) {

        int count = 0;

        int []move_x = {-1, 1, 0, 0};
        int []move_y = {0, 0, -1, 1};

        Queue<Integer[]> que = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i=0; i < row; i++) {

            for (int j=0; j < column; j++) {

                if ( board[i][j] == REMAIN ) {

                    que.add(new Integer[]{i, j});
                    board[i][j] = CHK;

                    int width = 1;
                    count++;
                    while( !que.isEmpty() ) {

                        Integer []position = que.poll();
                        for (int k=0; k < 4; k++) {

                            int x = position[0] + move_x[k];
                            int y = position[1] + move_y[k];

                            if (x < 0 || y < 0 || x >= row || y >= column)
                                continue;
                            if (board[x][y] != REMAIN)
                                continue;

                            board[x][y] = CHK;
                            que.add(new Integer[]{x, y});
                            width++;

                        }

                    }
                    result.add(width);

                }

            }

        }

        int []array = new int[count];
        for (int i=0; i < count; i++)
            array[i] = result.poll();

        Arrays.sort(array);
        result.add(count);
        for (int e:array)
            result.add(e);

        return result;

    }

    void print(int[][] board,int row, int column) {
        for (int i=0; i < row; i++) {
            for (int j=0; j < column; j++)
                System.out.printf("%2d", board[i][j]);
            System.out.println();
        }
        System.out.println("------------------------");
    }

}
