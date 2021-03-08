package chap03.binarySearch;

import chap03.Chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class BinSearch implements Chapter03 {

    private Scanner sc;

    @Override
    public void start() {

        // 이진탐색은 정렬이 되어있는 데이터에서 가능함
        sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int[] list = this.getList(sc.nextInt());

        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

        // 이진검색 표준 라이브러리 활용
        int result = Arrays.binarySearch(list, key);
        //Integer result = this.getKeyIndex(list,key);
        System.out.println(result);

        if (result > -1) {
            System.out.printf("%d은(는) x[%d]에 있습니다.", key, result);
        } else {
            System.out.print("해당 값이 존재하지 않습니다.");
        }

    }

    /**
     * 리스트 생성 메소드
     * @param count
     * @return
     */
    private int[] getList(int count){

        int[] list = new int[count];
        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        list[0] = sc.nextInt();

        for (int i = 1; i < count; i++){
            // 오름차순으로 입력되어야 하기 때문에 만약 입력한 값이 이전 값보다 작을 경우 재입력
            // 메모리 낭비를 최소화하며 최소한 한 번 실행되어야 하기에 for문 내부에 do-while문 작성
            do {
                System.out.printf("x[%d] : ", i);
                list[i] = sc.nextInt();
            } while (list[i] < list[i-1]);
        }

        return list;

    }

    /**
     * index 값 반환 메서드
     * @param list
     * @param key
     * @return
     */
    private Integer getKeyIndex(int[] list, int key){

        // 시작 index
        int pl = 0;
        // 끝 index
        int pr = list.length - 1;

        do {

            // 중간 index
            int pc = (pl + pr) / 2 ;

            if (key == list[pc]) return pc;
            else if (key > list[pc]) pl = pc + 1;
            else if (key < list[pc]) pr = pc - 1;

        } while (pl <= pr);

        return null;

    }

}
