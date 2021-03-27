package chap03.queue;

import chap03.Chapter03;

import java.util.Scanner;

public class IntRingBufferQueueTester implements Chapter03 {

    private Scanner sc;

    public IntRingBufferQueueTester() {
        sc = new Scanner(System.in);
    }

    private void controller() {

        IntRingBufferQueue que = new IntRingBufferQueue(10);

        while (true) {

            System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (5)검색 (0)종료 : ");
            int menu = sc.nextInt();

            if (menu == 0) break;

            switch (menu) {

                case 1:
                    try {
                        System.out.print("값: ");
                        menu = que.enqueue(sc.nextInt());
                    } catch (IntRingBufferQueue.OverFlowRingBufferQueueException e) {
                        System.out.println("큐가 가득찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        menu = que.dequeue();
                        System.out.printf("디큐: %d\n", menu);
                    } catch (IntRingBufferQueue.EmptyRingBufferQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 3:
                    try {
                        menu = que.peek();
                        System.out.printf("피크: %d\n", menu);
                    } catch (IntRingBufferQueue.EmptyRingBufferQueueException e) {
                        System.out.println("큐가 비었습니다.");
                    }
                    break;

                case 4:
                    que.dump();
                    break;

                case 5:
                    try {
                        System.out.print("검색 값: ");
                        menu = que.indexOf(sc.nextInt());
                        System.out.printf("큐 위치: %d\n", menu);
                    } catch (IntRingBufferQueue.EmptyRingBufferQueueException e) {
                        System.out.println("큐가 비었습니다.");
                    }
                    break;

            }

        }

    }

    @Override
    public void start() {
        this.controller();
    }

}
