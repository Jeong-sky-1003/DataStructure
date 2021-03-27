package chap03.queue;

import chap03.Chapter03;

import java.util.Scanner;

public class IntAryQueueTester implements Chapter03 {

    private Scanner sc;

    public IntAryQueueTester() {
        sc = new Scanner(System.in);
    }

    private void controller() {

        IntAryQueue que = new IntAryQueue(5);

        while (true) {

            System.out.print("메뉴 입력: ");
            int menu = sc.nextInt();

            if (menu == 0) break;

            switch (menu) {

                case 1:
                    try {
                        System.out.print("값: ");
                        que.enqueue(sc.nextInt());
                    } catch (IntAryQueue.OverFlowQueueException e) {
                        System.out.println("영역 초과");
                    }
                    break;

                case 2:
                    try {
                        menu = que.dequeue();
                        System.out.printf("디큐 진행 : %d\n", menu);
                    } catch (IntAryQueue.EmptyQueueException e) {
                        System.out.println("값이 존재하지 않음");
                    }
                    break;

                case 3:
                    try {
                        que.dump();
                    } catch (IntAryQueue.EmptyQueueException e) {
                        System.out.println("값이 존재하지 않음");
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
