package inflearn.section2;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Recursion5 implements MyStart {

    private int n = 2;
    private int m = 2;

    private int[][] grid;
    private int result = 0;

    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR = 1;
    private static int ALREADY_COUNTED = 2;

    private int countCells(int x, int y){

        if ( x < 0 || x >= n || y >= m || y < 0 ) {
            return 0;
        }
        else if ( grid[x][y] != Recursion5.IMAGE_COLOR ) {
            return 0;
        }
        else {
            grid[x][y] = Recursion5.ALREADY_COUNTED;

            // 북: x-1, y / 북동: x-1, y+1 / 동: x, y+1 / 북서: x-1, y-1
            // 남동: x+1, y+1 / 남: x+1, y / 남서: x+1, y-1 / 서: x, y-1
            return 1    + countCells(x-1, y-1)
                        + countCells(x-1, y+1)
                        + countCells(x, y+1)
                        + countCells(x+1, y+1)
                        + countCells(x+1, y)
                        + countCells(x-1, y)
                        + countCells(x+1, y-1)
                        + countCells(x, y-1);
        }

    }

    private void print(){
        for(int i=0; i < grid.length; i++){
            for (int j=0; j < grid[i].length; j++){
                System.out.printf("%d  ", grid[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void start() throws Exception{

        System.out.print("n(x): ");
        n = sc.nextInt();

        System.out.print("m(y): ");
        m = sc.nextInt();

        grid = new int[n][m];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i < n; i++){
            String input = reader.readLine();
            for (int j=0; j < m; j++){
                grid[i][j] = Integer.parseInt(input.substring(j,j+1));
            }
        }

        print();

        System.out.println("검사할 x, y 입력 ");
        String input = reader.readLine();

        int x = Integer.parseInt(input.split(",")[0]);
        int y = Integer.parseInt(input.split(",")[1]);

        int result = this.countCells(x, y);
        print();

        System.out.printf("결과: %d", result);

    }

}
