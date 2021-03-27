package chap04.recursive;

import chap04.Chap04;

// 분기한정법
public class QueenBB implements Chap04 {

    private boolean[] flag = new boolean[8];
    private int[] pos = new int[8];

    private void print() {
        for (int e : pos)
            System.out.printf("%d  ", e);
        System.out.println();
    }

    // i: column, j: row
    private void set(int i) {

        // 행에 퀸 위치 시키기
        for (int j = 0; j < 8; j++) {

            // flag[j]의 값이 false일 경우 아래 조건 시행
            // flag[j]가 true라는 것은 해당 위치에 queen을 배치하였다는 이야기이므로 for문으로 돌아가 다음 행 진행
            if (flag[j] == false) {

                pos[i] = j;
                if (i == 7) {
                    print();
                } else {
                    flag[j] = true;     // queen을 j행에 할당했기에 True 입력
                    set(i + 1);         // 재귀로 호출되어 메모리에 실행이 할당된 아이들 덕분에 i 값이 변화하며 루프가 형성되는 것
                    flag[j] = false;    // 같은 행을 활용할 것이기에 해당 j행을 false로 변환
                }

            }

        }

    }

    @Override
    public void start() {
        this.set(0);
    }

}
