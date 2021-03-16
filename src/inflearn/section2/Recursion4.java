package inflearn.section2;

import inflearn.Inflearn;

public class Recursion4 implements Inflearn {

    static class Maze{

        static int n = 8;

        // 0: 길, 1: 벽
        static int [][]maze = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 0, 1, 0, 0}
        };

        // 특정 셀을 방문하면 일단 3번으로 체크하며, 길이 아닐 경우 2로 체크
        static final int PATHWAY_COLOR = 0;    // white: 지나갈 수 있음
        static final int WALL_COLOR = 1;       // blue : 벽
        static final int BLOCKED_COLOR = 2;    // red  : 이미 방문한 위치, 출구 가는 길 아님
        static final int PATH_COLOR = 3;       // green: 이미 방문, 출구 가는 길 중 하나

    }

    // 위치 x, y로 부터 출구까지 가는 경로가 있는지를 판단
    // 좌표를 x, y로 받음
    private boolean findMazePath(int x, int y, int n){

        // 과정 체크하고 싶을 때 주석 해제하고 체크
        printMaze();

        if ( x < 0 || y < 0 || x >= n || y >= n ){
            // 범위 밖으로 벗어난 경우
            return false;
        } else if ( Maze.maze[x][y] != Maze.PATHWAY_COLOR ){
            // 현 위치가 지나갈 수 없거나 이미 지나갔던 길인 경우
            return false;
        } else if ( x == n-1 && y == n-1 ){
            // 출구인 경우
            Maze.maze[x][y] = Maze.PATH_COLOR;
            return true;
        } else {

            // 무한루프 체크
            // 먼저 방문한 좌표 체크. 아직 출구를 가는 길인지 아닌지 판단이 안 되기에 green으로 체크
            Maze.maze[x][y] = Maze.PATH_COLOR;

            // 인접한 셀 접근하기
            // 단, 조건이 있음 상하좌우로 기존에 방문하지 않은 좌표에만 접근함
            // 위에 검사했다가 오른쪽으로 쭉 가다가 아래로 검사하고, 그 다음엔 거꾸로 (즉, 북동남서 순서)
            if ( findMazePath(x - 1, y, n) || findMazePath(x, y + 1, n) ||
                    findMazePath(x + 1, y, n) || findMazePath(x, y - 1, n))
                return true;

            // 출구가 아닌 경우
            Maze.maze[x][y] = Maze.BLOCKED_COLOR;
            return false;

            // 재귀함수는 메모리에 stack 으로 메서드가 쌓이며 거꾸로 올라오며 수행함
            // 그러면서 갔던 길이 아니라는 것을 되돌아오며 판단할 수 있던 것임

        }

    }

    private void printMaze() {

        for(int i=0; i < Maze.n; i++){
            for (int j=0; j < Maze.n; j++){
                System.out.printf("%2d", Maze.maze[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");

    }

    @Override
    public void start() {

        printMaze();
        findMazePath(0,0, Maze.n);  // 입구로 부터 시작
        printMaze();

    }


}
