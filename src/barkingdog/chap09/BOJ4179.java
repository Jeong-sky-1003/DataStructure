package barkingdog.chap09;

import caseStudy.MyStart;

import java.util.Queue;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ4179 implements MyStart {

    static Integer [][]maze;

    static final Integer WALL = -1;
    static final Integer FIRE = -2;
    static final Integer JIHOON = 1;
    static final Integer NOT_YET = 0;

    @Override
    public void start() throws Exception {
        solve();
    }

    private void solve() throws Exception {

        Queue<Integer[]> que_J = new LinkedList<>();
        Queue<Integer[]> que_F = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []inputs = reader.readLine().split(" ");

        int row = Integer.parseInt(inputs[0]);
        int column = Integer.parseInt(inputs[1]);

        maze = new Integer[row][column];
        for (int i=0; i < row; i++) {

            String []input = reader.readLine().split("");

            for (int j=0; j < column; j++) {

                String str = input[j];
                if (str.equals("J")) {
                    que_J.add(new Integer[]{i, j});
                    maze[i][j] = JIHOON;
                } else if (str.equals("F")) {
                    que_F.add(new Integer[]{i, j});
                    maze[i][j] = FIRE;
                } else if (str.equals("#")) {
                    maze[i][j] = WALL;
                } else {
                    maze[i][j] = NOT_YET;
                }

            }

        }

        Integer result = maze(maze, que_J, que_F, row, column);

        if (result < 0) System.out.println("IMPOSSIBLE");
        else System.out.println(result);

    }

    private Integer maze(Integer[][] maze, Queue<Integer[]> que_J, Queue<Integer[]> que_F, int row, int column) {

        Integer result = 0;

        // x: 행, y: 열
        final int []move_x = {0, 0, -1, 1};
        final int []move_y = {1, -1, 0, 0};

        /*

            불과 지훈이의 이동 조건을 !que.isEmpty() 일 경우로 진행했으나, 시간 흐름에 따라 동시에 움직인다는 현실이 반영되지 않았음
            이로 결과에 오류가 발생함.

            각 que의 size로 이동을 제어한 결과 동시간에 움직이는 효과를 낼 수 있음.
            이전 풀이에서 간과했던 것은 지훈이가 있던 자리에 불이 갈 수 있는 것인데, 해당 조건이 적용되지 않았었음.
            또한 앞서 이야기하였듯 동시에 움직인다는 조건도 적용되지 않았음.

            지훈이는 무조건 0인 길만 움직일 수 있고, 불은 벽과 불이 지나온 길을 돌아갈 수 없음!
            이를 미로 생성에 반영해 숫자로 제어하여 해결할 수 있었던 것임.
            
            물론 시간초는 꽤 나왔지만 ㅠㅠ

         */

        int f_size, j_size;
        // 전체 반복
        while (true) {

            // 경과 시간
            result++;

            // 불 이동
            f_size = que_F.size();
            while ( f_size > 0 ) {
                f_size--;
                Integer []position = que_F.poll();
                for (int i=0; i < 4; i++ ) {

                    int x = position[0] + move_x[i];
                    int y = position[1] + move_y[i];

                    if ( x < 0 || y < 0 || x >= row || y >= column)
                        continue;

                    if ( maze[x][y] < NOT_YET )
                        continue;

                    que_F.add(new Integer[]{x, y});
                    maze[x][y] = FIRE;

                }   // for문 종료
                print(row, column);
            }

            // 지훈 이동
            j_size = que_J.size();
            while ( j_size > 0 ) {

                j_size--;
                Integer []position = que_J.poll();
                for (int i=0; i < 4; i++) {

                    int x = position[0] + move_x[i];
                    int y = position[1] + move_y[i];

                    if ( x < 0 || y < 0 || x >= row || y >= column)
                        return result;

                    if ( maze[x][y] != NOT_YET )
                        continue;

                    que_J.add(new Integer[]{x, y});
                    maze[x][y] = JIHOON;

                }
                print(row, column);

            }

            if (que_J.isEmpty()) return -1;

        }

    }

    void print(int r, int c) {
        for (int i=0; i < r; i++) {
            for (int j=0; j < c; j++)
                System.out.printf("%3d", maze[i][j]);
            System.out.println();
        }
        System.out.println("---------------------------");
    }

}
