package chap03.stack;

import chap03.Chapter03;

import java.util.Scanner;

public class IntStackTester implements Chapter03 {

    private Scanner sc;

    public IntStackTester() {
        sc = new Scanner(System.in);
    }

    private void controller() {

        IntStack stk = new IntStack(7);

        while (true) {

            System.out.printf("\n현재 데이터 수 : %d/%d\n", stk.size(), stk.capacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 검색 (6) 전체 삭제 "
                    + "(7) 데이터 수 확인 (8) empty 여부 (9) 가득 찼는가 (0) 종료 : ");
            int menu = sc.nextInt();

            if (menu == 0) break;
            int result = 0;
            boolean isResult = false;

            switch (menu) {

                case 1:
                    System.out.print("입력 데이터: ");
                    result = sc.nextInt();
                    try {
                        stk.push(result);
                    } catch (IntStack.OverFlowIntStackException e) {
                        System.out.println("스택이 가득찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        result = stk.pop();
                        System.out.printf("팝한 데이터: %d\n", result);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:
                    try {
                        result = stk.peek();
                        System.out.printf("꼭대기 데이터: %d\n", result);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 4:
                    try {
                        stk.dump();
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 5:
                    try {
                        System.out.print("검색할 값: ");
                        result = stk.indexOf(sc.nextInt());

                        if (result >= 0) System.out.printf("%d에 위치합니다.", result);
                        else System.out.println("값이 존재하지 않습니다.");

                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 6:
                    try {
                        stk.clear();
                        System.out.println("데이터 클리어를 완료했습니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 7:
                    try {
                        result = stk.size();
                        System.out.printf("현 데이터 수: %d", result);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("데이터가 비어있습니다.");
                    }
                    break;

                case 8:

                    isResult = stk.isEmpty();

                    if (isResult) System.out.println("데이터가 비어있습니다.");
                    else System.out.println("데이터가 비어있지 않습니다.");

                    break;

                case 9:

                    isResult = stk.isFull();

                    if (isResult) System.out.println("데이터가 가득찼습니다.");
                    else System.out.println("데이터가 가득차지 않았습니다.");

                    break;

            }

        }

    }

    @Override
    public void start() {
        this.controller();
    }

}
