package springStudy.chap02;

import baekjoon.BackJoon;

// 예제 2-7. 71패이지
public class Start6 implements BackJoon {

    static int share;

    class Start6Class extends Thread {

        public void run() {

            try {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s, i: %d, share %d\n", this.getName(), i, share++);
                    sleep(2000);
                }
            } catch (InterruptedException e) {

            }

        }

    }

    @Override
    public void start() {

        Start6Class s1 = new Start6Class();
        Start6Class s2 = new Start6Class();

        // start() Thread에 내장된 메서드인듯함
        s1.start();
        s2.start();

    }

}
