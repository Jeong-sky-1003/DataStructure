package barkingdog.chap01;

import caseStudy.MyStart;

public class Question1 implements MyStart {

    @Override
    public void start() throws Exception {
        System.out.println(func4_barkingdog(97615282));
    }

    // 이 경우 시간 복잡도는 O(N)이 아닐까?
    // 시간복잡도: O(N)
    private int func1(int n) {
        int sum = 0;
        for (int i=1; i <= n; i++)
            if (i%3 == 0 || i%5 == 0) sum += i;
        return sum;
    }

    // 이중 for문을 사용했으니 O(N의 제곱)인가..?
    // O(N의 제곱 log N)을 만들 수 있을까??
    // func2의 O(N) 풀이도 존재함! 어떻게???
    // 0X03 강의에서 설명 예정
    private int func2(int []arr, int n) {
        for ( int i=0; i < n; i++ ){
            for ( int j=i+1; j < n; j++ ){
                if (arr[i] + arr[j] == 100)
                    return 1;
            }
        }
        return 0;
    }

    // 제곱수 반환하는 함수
    private int func3(int n){
        // 이 경우 최대 루트 N까지 올라가 시간 복잡도는 O(루트 N)
        for (int i=1; i * i <= n; i++){
            if (i*i == n) return 1;
        }
        return 0;
        /*
            하늘 풀이
            int sum = 0;
            for (int i=1; i <= n; i = i+2) {
                sum += i;
                if (sum == n) return 1;
            }
            return 0;
         */
    }

    // 하늘 코드: 26번 반복
    // 코드의 반복 횟수는 동일하나 코드 길이를 생각했을 떄, 바킹독 코드의 생산성이 굉장히 좋음
    // 라이브러리를 사용해 메모리를 좀 더 차지할 것으로 보임
    private int func4(int n) {
        int result = 0;
        for (int i=1; Math.pow(2, i) <= n; i++) {
            result = (int) Math.pow(2, i);
        }
        return result;
    }

    // 바킹독 코드: 26번 반복
    // 라이브러리를 사용하지 않고 계산해 메모리 차지가 훨씬 적음
    // 시간복잡도는 O( log N ) 아닐까? 
    private int func4_barkingdog(int n) {
        int var = 1;
        while (2*var <= n)  var *= 2;
        return var;
    }

}
