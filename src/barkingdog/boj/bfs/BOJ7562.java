package barkingdog.boj.bfs;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7562 implements MyStart {

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(reader.readLine());

        for (int i=0; i < testCase; i++) {

            Queue<Integer[]> que = new LinkedList<>();

            int num = Integer.parseInt(reader.readLine());
            int [][]board = new int[num][num];

            String []cur = reader.readLine().split(" ");
            String []moveTO = reader.readLine().split(" ");

            int x = Integer.parseInt(cur[0]);
            int y = Integer.parseInt(cur[1]);

            int moveToX = Integer.parseInt(moveTO[0]);
            int moveToY = Integer.parseInt(moveTO[1]);

            que.add(new Integer[]{x, y});
            board[x][y] = 1;

            if (x == moveToX && y == moveToY) {
                writer.append(0 + "\n");
            } else {
                int result = BFS(que, board, num, moveToX, moveToY);
                writer.append(result + "\n");
            }

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    void print(int [][] board, int n) {

        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++)
                System.out.printf("%2d", board[i][j]);
            System.out.println();
        }
        System.out.println("---------------------");

    }

    int BFS(Queue<Integer[]> que, int[][] board, int n , int moveToX, int moveToY) {

        int count = 0;

        int []move_x = {-2, -2, -1, -1, 1, 1, 2, 2};
        int []move_y = {1, -1, 2, -2, 2, -2, -1, 1};

        while (true) {

            count++;
            int size = que.size();
            for (int i=0; i < size; i++) {

                Integer[] position = que.poll();
                for (int j=0; j < 8; j++) {

                    int x = position[0] + move_x[j];
                    int y = position[1] + move_y[j];

                    if (x == moveToX && y == moveToY)
                        return count;

                    if (x < 0 || y < 0 || x >= n || y >= n)
                        continue;

                    if (board[x][y] != 0)
                        continue;

                    que.add(new Integer[]{x, y});
                    board[x][y] = 1;

                }

            }

        }

    }

}
