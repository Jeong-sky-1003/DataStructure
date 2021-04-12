package barkingdog.chap05;

import caseStudy.MyStart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SolveBOJ implements MyStart {

    static Stack<Long> heightStk = new Stack<>();

    @Override
    public void start() throws Exception {
        BOJ6198_4();
    }

    // 타인 풀이 (2)
    private void BOJ6198_4() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        long result = 0;

        for (int i=0; i < num; i++) {
            long input = Long.parseLong(reader.readLine());
            result += cal_4(input);
        }

        System.out.println(result);

    }

    private long cal_4(long input) {

        while (true) {
            if (heightStk.isEmpty()) {
                heightStk.push(input);
                return 0;
            } else {
                long height = heightStk.peek();
                if ( height > input ) {
                    heightStk.push(input);
                    return heightStk.size()-1;
                } else {
                    heightStk.pop();
                    continue;
                }
            }
        }

    }

    // 타인 풀이 (1)
    private void BOJ6198_3() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        long result = 0;

        /*
            계산법 접근은 각 건물이 몇 개까지 가능한가가 아닌
            각 건물을 볼 수 있는 건물의 갯수는 몇개인가로 접근하는게 좋음
            그래서 입력받은 즉시 이전에 존재한 건물과 비교해 해당 건물을 볼 수 있는 건물의 갯수를 카운트하는 것임
         */

        // 해당 스택은 input되는 건물을 볼 수 있는 건물의 리스트를 남기기 위한 것
        Stack<Long> numStk = new Stack<>();

        for (int i=0; i < num; i++) {

            // 다음 건물의 높이를 받음
            Long input = Long.parseLong(reader.readLine());

            // 건물의 리스트가 비어있지 않다면 input된 건물을
            // 볼 수 있는지 체크하기 위함
            while (!numStk.empty()) {
                // 들어오는 건물의 층수보다 기존 건물의 층수가 낮은 경우 해당 건물은 볼 수 있는 건물에서 삭제
                // 아래 조건문으로 인해 건물의 높이 리스트는 이미 내림차순으로 리스트에 삽입되어 있음
                if (numStk.peek() <= input) numStk.pop();
                // 기존에 있는 건물이 들어온 건물의 위를 볼 수 있는 경우 해당 건물을 볼 수 있음
                else break;
            }
            // 들어온 건물보다 층수가 낮은 건물을 삭제하고, 볼 수 있는 건물만 남았기에
            // 해당 건물의 갯수를 계산하여 결과에 더함
            result += numStk.size();
            // 들어온 건물을 체크하기 위해 리스트에 추가
            numStk.push(input);

        }

        System.out.println(result);

    }

    // 시간 초과
    private void BOJ6198_2() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int num = Integer.parseInt(reader.readLine());
        int []nums = new int[num];

        for (int i=0; i < num; i++)
            nums[i] = Integer.parseInt(reader.readLine());

        for (int i=0; i < num-1; i++) {
            int size = 1;
            int pop = nums[i];
            while ( pop > nums[i+size] ) {
                size++;
                result++;
                if (i+size >= num) break;
            }
        }

        System.out.println(result);

    }

    // BOJ 6198번: 빌딩
    // 시간초과 발생
    private void BOJ6198() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 빌딩의 수
        int num = Integer.parseInt(reader.readLine());
        int result = 0;

        Stack<Integer> numbers = new Stack<>();
        int []tmp = new int[num];
        for (int i=0; i < num; i++)
            tmp[i] = Integer.parseInt(reader.readLine());

        for (int i=num-1; i >=0; i--)
            numbers.push(tmp[i]);

        while (numbers.size() > 2) {
            int size = 1;
            int pop = numbers.pop();
            while ( pop > numbers.get(numbers.size()-size) ) {
                size++;
                result++;
            }
        }

        if ( numbers.pop() > numbers.peek() ) result++;
        System.out.println(result);

    }

    // BOJ 2493번: 타인 풀이
    private void BOJ2493_stranger() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(reader.readLine());
        int []numbers = new int[num+1];
        int []result = new int[num+1];

        String []numsStr = reader.readLine().split(" ");

        for (int i=1; i <= num; i++) {

            numbers[i] = Integer.parseInt(numsStr[i-1]);

            if ( i == 1 ) {
                result[i] = 0;
            } else {

                if ( numbers[i] < numbers[i-1] ) {
                    result[i] = i-1;
                } else {

                    int j = i-1;
                    while (j > 0) {
                        if ( numbers[i] < numbers[j] ) {
                            result[i] = j;
                            break;
                        }
                        j = result[j];
                    }

                }

            }
            writer.append(result[i] + " ");

        }

        writer.flush();
        writer.close();
        reader.close();

    }

    // BOJ 2493번: 탑
    private void BOJ2493() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(reader.readLine());
        String []numbers = reader.readLine().split(" ");

        Stack<Integer> numStk = new Stack<>();
        Stack<Integer> sortNumStk = new Stack<>();

        for ( int i=0; i < num; i++ ) {

            int tmp = Integer.parseInt(numbers[i]);
            while (true) {

                if (numStk.isEmpty()) {
                    numStk.push(tmp);
                    sortNumStk.push(i+1);
                    writer.append(0 + " ");
                    break;
                }

                if (numStk.peek() < tmp) {
                    numStk.pop();
                    sortNumStk.pop();
                } else if (numStk.peek() > tmp) {
                    numStk.push(tmp);
                    writer.append(sortNumStk.peek() + " ");
                    sortNumStk.push(i+1);
                    break;
                }

            }

        }

        writer.flush();
        writer.close();
        reader.close();

    }

}
