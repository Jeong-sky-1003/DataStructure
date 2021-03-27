package chap04.recursive;

import chap03.stack.IntStack;
import chap04.Chap04;

import java.util.Scanner;
import java.util.Stack;

public class Hanoi implements Chap04 {

    private Scanner sc;

    public Hanoi() {
        sc = new Scanner(System.in);
    }

    /**
     * num : 원반 번호
     * start : 현재 기둥 위치
     * goal : 이동 목표 기둥
     */
    private void hanoi(int num, int start, int goal) {

        Stack<Integer> stkTest = new Stack<>();
        stkTest.push(0);

        // 첫 이동 제어
        // 기둥은 무조건 3개임
        if (num > 1)
            hanoi(num - 1, start, 6 - start - goal);

        System.out.printf("%d번 원반: %d -> %d\n", num, start, goal);

        // 이동한 뒤 추가 이동
        if (num > 1)
            hanoi(num - 1, 6 - start - goal, goal);

    }

    private void hanoiVer2(int num, int start, int goal) {

        int chk = 0;    // 0: 재귀 미 완료, 1: 재귀 완료

        IntStack startStack = new IntStack(100);
        IntStack goalStack = new IntStack(100);
        IntStack chkStack = new IntStack(100);

        while (true) {

            // 재귀가 완료되지 않은 원판의 이동
            if (chk == 0 && num > 1) {

                // 동일한 위치에 값을 각각 push 해줌
                startStack.push(start);
                goalStack.push(goal);
                chkStack.push(chk);

                // 이동할 다음 원판의 번호로 이동
                num--;
                goal = 6 - start - goal;

                System.out.printf("1번 조건 num: %d, chk: %d\n", num, chk);
                continue;

            }

            System.out.printf("%d번 원반: %d -> %d\n", num, start, goal);

            // 재귀가 1차 완료된 원판의 이동
            if (chk == 1 && num > 1) {

                startStack.push(start);
                goalStack.push(goal);
                chkStack.push(chk);

                num--;
                start = 6 - start - goal;

                System.out.printf("2번 조건 num: %d, chk: %d\n", num, chk);

                if (++chk == 2) chk = 0;
                continue;

            }

            // 값을 저장한 데이터를 pop하여 위 출력문에서 출력하게 유도하기 위함
            do {

                try {
                    start = startStack.pop();
                    goal = goalStack.pop();
                    chk = chkStack.pop() + 1;   // 이동 1차 완료되었음 체크
                    System.out.printf("%d번 원반 pop, chk 값 확인: %d\n", num, chk);
                    num++;  // 원판의 갯수 회복
                } catch (IntStack.EmptyIntStackException e) {

                }

            } while (chk == 2);

            System.out.println("------------------------------------------");

        }

    }

    @Override
    public void start() {

        System.out.print("원반 갯수 : ");
        int num = sc.nextInt();

        hanoiVer2(num, 1, 3);

    }

}
