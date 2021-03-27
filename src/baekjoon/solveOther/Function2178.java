package baekjoon.solveOther;

import baekjoon.BackJoon;

import java.util.LinkedList;
import java.util.Queue;

public class Function2178 implements BackJoon {

    // 너비우선탐색 (BFS) 알고리즘
    /*

        너비우선탐색 (BFS)
            가까운 경로 후보부터 탐색하는 방법
            한 쪽 길을 끝까지 먼저 탐색하는 '깊이 우선 탬색(DFS)'와 비교됨

        언제 사용하는가?
            최단 경로 구하기: 목적지를 찾자마자 최단 경로가 보장되어 탐색 종료 가능해 DFS에 비해 빠름
            재귀로 시스템 스택을 사용하는 DFS에 비해 queue를 사용해 스택오버플로우에서 비교적 자유로음
            힙 공간을 넓게 사용할 수 있어 넓은 범위 탐색에 유리함

     */

    static class Maze {

        static int n = 4;
        static int m = 6;

        // 1: 이동 가능, 0: 이동 불가
        static int[][] maze = {
                {1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1}
        };

        // 방문한 곳 체크
        static int[][] visited = new int[4][6];

    }

    private boolean check(int x, int y) {

        //System.out.printf("check method - x: %d, y %d\n", x, y);

        // x 좌표가 너무 작거나, 크거나. y가 너무 크거나 작거나.
        if (y < 0 || y >= Maze.m || x < 0 || x >= Maze.n) {
            //System.out.println("좌표 크기 false");
            return false;
        }
        if (Maze.maze[x][y] == 0) {
            // 벽인 경우 false
            //System.out.println("벽 만남");
            return false;
        }
        if (Maze.visited[x][y] > 0) {
            // 이미 방문한 좌표인 경우
            //System.out.println("이미 방문");
            return false;
        }
        //System.out.println("문제 없이 true 리턴!");
        return true;

    }

    // 미로 탈출은 (n-1, m-1) 좌표다.
    private int searchDFS(int x, int y) {

        // count를 위한 queue
        Queue<Integer> que_count = new LinkedList<>();

        /*
            que_count 는 한 좌표를 기준으로 이동한 횟수를 계산한 것임
            이는 아래의 que_x, que_y와 동일한 순서로 기입됨
            고로 queue 앞에 있는 값을 꺼내 더하고 다시 삽입하며 각 방식에 대한 이동 결과 값 계산이 가능한 것임
         */

        // x와 y의 좌표를 나타내는 queue
        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y = new LinkedList<>();

        // 초기 위치
        queue_x.add(0);
        queue_y.add(0);

        // 시작지점부터 계산하기에 1부터 시작
        que_count.add(1);
        int result = 0;

        // queue 의 값이 empty( ) 가 아닌 동안 반복문 진행
        while (queue_y.isEmpty() == false) {

            int count = que_count.poll();
            result = count;
            //System.out.printf("\nfirst count chk: %d\n", count);

            // queue.poll(); 첫 번째 값을 삭제하고 리턴
            int current_x = queue_x.poll();
            int current_y = queue_y.poll();

            // 이미 방문이 체크되어 있다면 continue 로 돌아감
            if (Maze.visited[current_x][current_y] != 0) continue;
            // 방문한 곳이 체크되어 있지 않다면 방문여부 체크
            Maze.visited[current_x][current_y] = 1;
            printMaze();

            //System.out.printf("cur_x: %d, cur_y: %d, count: %d\n", current_x, current_y, count);
            //System.out.println("que is empty chk: " + queue_y.isEmpty());

            // 마지막 지점 도달시 break; - 예외처리
            if (Maze.n == current_x && Maze.m == current_y) {
                //System.out.println("break 조건 만족");
                break;
            }

            // 상하좌우 방문 표현
            // x: 행, y: 열

            // 상
            if (check(current_x - 1, current_y)) {
                //System.out.println("위로 이동");
                queue_x.add(current_x - 1);
                queue_y.add(current_y);
                que_count.add(count + 1);
            }

            // 하
            if (check(current_x + 1, current_y)) {
                //System.out.println("아래로 이동");
                queue_x.add(current_x + 1);
                queue_y.add(current_y);
                que_count.add(count + 1);
            }

            // 좌
            if (check(current_x, current_y - 1)) {
                //System.out.println("왼쪽으로 이동");
                queue_x.add(current_x);
                queue_y.add(current_y - 1);
                que_count.add(count + 1);
            }

            // 우
            if (check(current_x, current_y + 1)) {
                //System.out.println("오른쪽으로 이동");
                queue_x.add(current_x);
                queue_y.add(current_y + 1);
                que_count.add(count + 1);
            }

        }

        return result;

    }

    private void printMaze() {

        for (int i = 0; i < Maze.n; i++) {

            for (int j = 0; j < Maze.m; j++) {
                System.out.print(Maze.visited[i][j] + "  ");
            }
            System.out.println("");

        }
        System.out.println("----------------------");

    }


    @Override
    public void start() {

        int result = this.searchDFS(0, 0);
        System.out.println(result);

    }

}
