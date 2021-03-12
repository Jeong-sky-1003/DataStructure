package chap04.recursive;

import chap04.Chap04;

import java.util.Scanner;

public class EuclidGCDAry implements Chap04 {

    private Scanner sc;

    public EuclidGCDAry(){
        sc = new Scanner(System.in);
    }

    // 비재귀로 진행하는 이유는 무한루프 방지
    private int gcd(int x, int y){

        // 받아온 요소의 최대공약수 구하기
        while (y != 0){
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;

    }

    // 배열 요소 받아오기
    // num: 요소 갯수, start: 시작 번호
    private int gcdArray(int[] array, int start, int num){
        System.out.printf("start: %d, num: %d\n", start, num);
        if (num == 1){
            int result = array[start];
            System.out.printf("1번 조건 리턴 값: %d", result);
            return result;
        } else if (num == 2){
            int result = gcd(array[start], array[start + 1]);
            System.out.printf("2번 조건 리턴 값: %d, x: %d, y: %d\n", result, array[start], array[start + 1]);
            return result;
        } else {
            int result = gcdArray(array, start+1, num-1);
            System.out.printf("3번 조건 리턴 값: %d, x: %d, y: %d\n", result, array[start], result);
            return gcd(array[start], result);
        }
    }

    @Override
    public void start() {

        System.out.print("배열 요솟수 결정: ");

        // 요솟수 예외처리
        int capacity;
        do {
            capacity = sc.nextInt();
        } while (capacity <= 0);

        // 배열 생성
        int []array = new int[capacity];

        // 배열 내 데이터 입력
        for (int i = 0; i < capacity; i++){
            System.out.printf("%d번 요소: ", i);
            array[i] = sc.nextInt();
        }

        System.out.printf("의 최대공약수: %d", gcdArray(array, 0, capacity));

    }

}
