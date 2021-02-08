package chap03.linearSearch;

import chap03.Chapter03;

import java.util.Scanner;

/**
 * 선형검색 구현
 */
public class SeqSearch implements Chapter03 {

    private Scanner sc;

    public SeqSearch(){
        sc = new Scanner(System.in);
    }

    /**
     * 보초법 적용 메서드
     * @param list
     * @param number
     * @return
     */
    private int sentinelMethod(int[] list, int number){

        int count = 0;
        int index = 0;
        // 보초 추가
        list[list.length - 1] = number;

        while (true){
            count++;
            System.out.println(count + "회 실행");
            if (list[index] == number)
                break;
            index++;
        }

        return index == list.length? -1 : index;

    }

    /**
     * 보초법 미적용 메서드
     * @param list
     * @param number
     * @return
     */
    private int seqSearch(int[] list, int number){
        // 106페이지 실행결과 예제 입력 : 실행횟수 5회
        int count = 0;
        for (int i=0; i < list.length; i++){
            count++;
            System.out.println(count + "회 실행");
            if (list[i] == number) return i;
        }

        return -1;

    }

    private void print(int number, int result){
        if (result > -1) System.out.printf("%d는 x[%d]에 있습니다.", number, result);
        else System.out.println("값이 존재하지 않습니다.");
    }

    @Override
    public void start() {

        System.out.print("요솟수: ");
        int number = sc.nextInt();

        // 보초법 미적용
        //int[] list = new int[number];

        // 보초법 적용
        int[] list = new int[number + 1];

        for (int i = 0; i < number; i++){
            System.out.printf("x[%d] : ", i);
            list[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : ");
        number = sc.nextInt();

        // 보초법 미적용
        // int result = seqSearch(list, number);

        // 보초법 적용
        int result = sentinelMethod(list, number);
        print(number, result);

    }

}
