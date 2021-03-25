package baekjoon.function;

import baekjoon.BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Function2292 implements BackJoon {

    // 타인 풀이
    private long run2(long number){

        /*
            해당 풀이의 포인트는 겹의 값 범위를 기반으로 접근 범위를 체크하는 것임
            마지막 최대값으로만 접근을 하는 것임
         */

        long count = 1;     // 겹 접근
        long range = 1;     // 숫자의 범위를 나타내기 위함
        long sum = 1;       // 벌집 내에서의 6의 배수 범위를 나타내기 위함

        while (true){

            System.out.printf("sum: %d, count: %d, range: %d\n", sum, count, range);

            if ( sum >= number)
                return count;

            sum = sum + (6 * count++);
            range += sum;

        }

    }

    // 결과는 잘 출력되나 메모리 초과로 실패 .. 흐으므
    private int run(int number) {

        // 기준 번호
        Queue<Integer> number_que = new LinkedList<>();
        // 해당 값의 count
        Queue<Integer> count_que = new LinkedList<>();
        // 증가값
        Queue<Integer> increase_que = new LinkedList<>();

        for (int i = 2; i < 8; i++) {
            number_que.add(i);
            count_que.add(2);
            increase_que.add(i - 1);
        }

        while (true) {

            int check_num = number_que.poll();
            int increase_num = increase_que.poll();
            int count = count_que.poll() ;

            System.out.printf("get number: %d, increase num: %d, count: %d\n",
                    check_num, increase_num, count);

            if (check_num > number) {
                continue;
            }

            if (number == check_num) {
                return count;
            } else {

                count += 1;
                increase_num += 6;

                check_num += increase_num;

                number_que.add(check_num);
                increase_que.add(increase_num);
                count_que.add(count);

                number_que.add(check_num + 1);
                increase_que.add(increase_num + 1);
                count_que.add(count);

                number_que.add(check_num - 1);
                increase_que.add(increase_num - 1);
                count_que.add(count);

            }

        }

    }

    @Override
    public void start() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long number = Integer.parseInt(reader.readLine());

        number = run2(number);
        System.out.println(number);

    }

}
