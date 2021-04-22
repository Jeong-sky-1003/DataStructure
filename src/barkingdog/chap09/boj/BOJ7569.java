package barkingdog.chap09.boj;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7569 implements MyStart {

    final int TOMATO = 1;
    final int NOT_YET = 0;
    final int WALL = -1;

    @Override
    public void start() throws Exception {
        solve();
    }

    private void solve() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int column = Integer.parseInt(inputs[0]);
        int row = Integer.parseInt(inputs[1]);
        int height = Integer.parseInt(inputs[2]);

        Queue<Integer[]> que = new LinkedList<>();

        // 3차원 배열: height, row, column
        int [][][]boxes = new int[height][row][column];
        int zero_cnt = 0;

        for (int i=0; i < boxes.length; i++) {

            // row
            for (int j=0; j < boxes[0].length; j++) {

                inputs = reader.readLine().split(" ");
                // column
                for (int k=0; k < boxes[0][0].length; k++) {
                    int num = Integer.parseInt(inputs[k]);
                    if (num == 1) que.add(new Integer[]{i, j, k});
                    if (num == 0) zero_cnt++;
                    boxes[i][j][k] = num;
                }

            }

        }

        if (que.isEmpty())
            System.out.println(0);
        else {
            int result = BFS(que, boxes, row, column, height, zero_cnt);
            System.out.println(result);
        }

    }

    int BFS(Queue<Integer[]> que, int[][][] boxes,int row, int column, int height, int zero_cnt) {

        int count = 0;
        int result = 0;

        //  상, 하, 좌, 우, 앞 상자, 뒷 상자
        int []move_x = {0, 0, -1, 1, 0, 0};
        int []move_y = {-1, 1, 0, 0, 0, 0};
        int []move_z = {0, 0, 0, 0, 1, -1};

        while ( !que.isEmpty() ) {

            if (count == zero_cnt) return result;

            int que_size = que.size();
            for (int rep = 0; rep < que_size; rep++) {

                // height, row, column
                Integer[] position = que.poll();
                for (int i=0; i < 6; i++) {

                    int z = position[0] + move_z[i];
                    int x = position[1] + move_x[i];
                    int y = position[2] + move_y[i];

                    if (x < 0 || y < 0 || z < 0 || x >= row || y >= column || z >= height)
                        continue;

                    if (boxes[z][x][y] != NOT_YET)
                        continue;

                    boxes[z][x][y] = TOMATO;
                    que.add(new Integer[]{z, x, y});
                    count++;

                }

            }
            result++;

        }

        return -1;

    }

    void print(int[][][] boxes) {

        for (int i=0; i < boxes.length; i++) {

            // row
            for (int j=0; j < boxes[0].length; j++) {
                // column
                for (int k=0; k < boxes[0][0].length; k++)
                    System.out.printf("%2d", boxes[i][j][k]);
                System.out.println();
            }
            System.out.println(" ");
        }

    }

}
