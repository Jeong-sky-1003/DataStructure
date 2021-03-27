package chap04.recursive;

import chap03.stack.IntStack;
import chap04.Chap04;

import java.util.Scanner;

public class RecurX2 implements Chap04 {

    private Scanner sc;

    public RecurX2() {
        sc = new Scanner(System.in);
    }

    private void recure(int n) {

        IntStack stk = new IntStack(n);

        while (true) {

            if (n > 0) {
                stk.push(n);    // 재귀에서 n은 임시로 저장되고 연산된 값이 넘어가 재귀함수가 반복되고 있었기에 stack에 임시 저장로
                n -= 1;         // 첫 조건인 n = n - 1 연산 수행
                continue;       // 조건을 불만족 할때까지 while문 반복
            }

            if (!stk.isEmpty()) {
                n = stk.pop();  // 꼭대기 값 출력
                System.out.println(n);
                n -= 2;         // 이전 재귀 예제에서 n - 2로 값을 할당하고 출력하는 역할을 했었는데, 그 제어를 하기 위함
                // 즉, stack에 값을 저장하는 과정을 제어하기 위함
                continue;
            }

            break;

        }

    }

    @Override
    public void start() {
        System.out.print("입력 값: ");
        int n = sc.nextInt();
        this.recure(n);
    }

}
