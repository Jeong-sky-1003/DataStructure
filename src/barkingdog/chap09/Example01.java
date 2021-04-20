package barkingdog.chap09;

import caseStudy.MyStart;

import java.util.LinkedList;
import java.util.Queue;

public class Example01 implements MyStart {

    @Override
    public void start() throws Exception {
        BFS();
    }

    void BFS() {

        int n = 7;      // 행
        int m = 10;     // 열

        // board: 넓이를 탐색할 판
        int [][] board = new int[n][m];

        final int VISITED = 2;  // 방문 체크
        final int NOT_YET = 1;  // 방문해야함
        final int WALL = 0;     // 벽

        // 상하좌우 이동 기준
        // 입력 데이터 순서로 보면
        //              하, 우, 상, 좌
        int []move_x = {1, 0, -1, 0};   // 행
        int []move_y = {0, 1, 0, -1};   // 열

        // que
        Queue<Integer[]> que = new LinkedList<>();

        // (0, 0) 방문 표시 후 que에 push
        board[0][0] = VISITED;
        que.add(new Integer[]{0, 0});

        // que가 빌 때까지 상하좌우 이동과 칸 추가 반복
        while (!que.isEmpty()) {

            Integer []position = que.poll();
            for (int i=0; i < 4; i++) {

                // 이동할 x, y의 좌표
                int x = position[0] + move_x[i];
                int y = position[1] + move_y[i];

                // 만약 board의 범위를 벗어날 경우 반복문으로 돌아감
                // x와 y가 범위에 해당하는지 먼저 판별해야 함
                // 만약 그렇지 않고 아래 조건을 한다면 OutBoundOfRange와 같은 에러 발생
                if (x < 0 || y < 0 || x >= n || y >= m )
                    continue;
                // 만약 방문해야하지만 아직 방문한 곳이 아닌 경우가 아니라면 다시 반복문으로 돌아감
                if (board[x][y] != NOT_YET )
                    continue;

                board[x][y] = VISITED;
                que.add(new Integer[]{x, y});

            }

        }

    }

}
