package inflearn.section2;

import caseStudy.MyStart;

public class Recursion6 implements MyStart {

    int result = 0;
    static int num = 0;

    // 번호별로 flag 체크
    // 행 flag는 n 갯수 그대로임
    boolean[] flag_row = new boolean[8];

    // 대각선 flag는 n * 2 - 1 갯수임
    boolean[] flag_a = new boolean[15];
    boolean[] flag_b = new boolean[15];

    // queen 배치 배열 체크
    int []pos = new int[8];

    // 8퀸의 포인트는 i열에 놓인 위치가 j이면 queen[i] = j 임
    // 고로 queen을 배치하는 메서드의 매개변수는 column 값이라는 것
    // 왜냐면 모든 컬럼의 행을 돌아야하기 때문
    private void queen(int col, int num) {

        // 8 Queen 이므로 8번 돌아야 함
        for (int row = 0; row < num; row++) {

            if ( flag_row[row] == false &&
                 flag_a[row + col] == false &&
                 flag_b[col - row + num - 1] == false){

                pos[col] = row;
                if (col == 7){
                    result++;
                    print();
                } else {
                    flag_row[row] = flag_a[row + col] = flag_b[col - row + num - 1] = true;
                    // 열을 하나 증가시켜 재귀함수 실행
                    queen(col+1, num);
                    flag_row[row] = flag_a[row + col] = flag_b[col - row + num - 1] = false;
                }

            }

        }

    }

    private void print(){
        for (int e:pos){
            System.out.printf("%d  ", e);
        }
        System.out.println();
    }

    @Override
    public void start() throws Exception {

        System.out.print("num: ");
        num = sc.nextInt();

        queen(0, num);
        System.out.printf("결과: %d", result);

    }

}
