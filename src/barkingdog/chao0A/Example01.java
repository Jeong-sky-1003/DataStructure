package barkingdog.chao0A;

import caseStudy.MyStart;

import java.util.Stack;

public class Example01 implements MyStart {

    @Override
    public void start() throws Exception {
        DFS();
    }

    private void DFS() throws Exception {

        final int WALL = 0;
        final int NOT_YET = 1;
        final int VISITED = 2;

        int n = 7, m = 10;
        int [][]board = new int[n][m];

        int []move_x = {-1, 1, 0, 0};
        int []move_y = {0, 0, -1, 1};

        Stack<Integer[]> stk = new Stack<>();
        stk.push(new Integer[]{0, 0});
        board[0][0] = VISITED;

        while (!stk.isEmpty()) {

            Integer[] position = stk.pop();
            for (int i=0; i < 4; i++) {

                int x = position[0] + move_x[i];
                int y = position[1] + move_y[i];

                if (x < 0 || y < 0 || x >= n || y >= m)
                    continue;

                if (board[x][y] != NOT_YET)
                    continue;

                board[x][y] = VISITED;
                stk.push(new Integer[]{x, y});

            }

        }

    }

}
