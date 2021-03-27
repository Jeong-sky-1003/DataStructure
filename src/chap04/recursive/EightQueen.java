package chap04.recursive;

import chap04.Chap04;

public class EightQueen implements Chap04 {

    // 행에 퀸이 위치하는지 검토
    private boolean[] flag_row = new boolean[8];

    // 대각선에 퀸이 위치하는지 검토
    private boolean[] flag_arrayA = new boolean[15];    // / 이런 대각선
    private boolean[] flag_arrayB = new boolean[15];    // \ 이런 대각선

    // 퀸 배치 배열
    private int[] pos = new int[8];

    // 8퀸 문제를 만족하는 총 경우의 수
    private int count = 0;

    private void print() {
        for (int e : pos)
            System.out.printf("%d  ", e);
        System.out.println();

    }

    private void printSquare() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == pos[i]) {
                    // 조건으로 pos[i]로 한 이유는 pos의 값 구조를 생각하면 됨
                    System.out.printf("%4s", "◼︎︎");
                }
                System.out.printf("%3s", "◻︎");
            }
            System.out.println();
        }
        System.out.println("---------------------------");

    }

    private void set(int column) {

        for (int row = 0; row < 8; row++) {

            // 대각선과 행, 열 위치에 값이 없을 경우 if문 진행
            if (
                    flag_row[row] == false &&
                            flag_arrayA[column + row] == false &&
                            flag_arrayB[column - row + 7] == false) {

                pos[column] = row;
                if (column == 7) {
                    // 모든 열에 퀸 위치를 할당하였기에 이 조건에서 count를 해주는 것이 바람직함
                    printSquare();
                    count++;
                } else {
                    // 값이 존재함을 명시
                    flag_row[row] = flag_arrayA[column + row] = flag_arrayB[column - row + 7] = true;
                    set(column + 1);
                    // 초기화
                    flag_row[row] = flag_arrayA[column + row] = flag_arrayB[column - row + 7] = false;
                }

            }

        }

    }

    @Override
    public void start() {
        set(0);
        System.out.printf("total: %d", count);
    }

}
