package inflearn.section2;

import inflearn.Inflearn;

public class Recursion3 implements Inflearn {

    // 이진탐색법 재귀함수로 구현하기
    // 데이터 타입은 String 이며 해당 값의 인덱스를 반환하라.
    private int binarySearch(String[] items, String target,
                             int begin, int end) {
        // begin은 메서드가 실행하면 하나씩 증가함
        // 만약 증가하다 end보다 커질 경우 -1을 반환함
        if (begin > end) return -1;
        else {

            // 이진탐색법은 가운데 값을 기준으로 진행함
            int mid = (begin + end) / 2;
            /*

                compareTo는 비교하는 문자열과 각각의 자리를 비교해
                비교 값에서 매개변수의 값을 뺄셈하여 차이를 int형으로 반환함

                tmpStr.compareTo(str); 메소드
                만약 tmpStr이 str과 같으면 0,
                만약 tmpStr이 str 보다 크면 1,
                만약 tmpStr이 str 보다 작으면 -1

             */
            if (items[mid].compareTo(target) == 0) return mid;
            else if (items[mid].compareTo(target) > 0)
                return binarySearch(items, target, mid + 1, end);
            else {
                // items[mid].compareTo(target) < 0
                // 즉, items[mid]의 값이 target 보다 작을 경우
                return binarySearch(items, target, begin, mid - 1);
            }

        }

    }

    private int search(int[] data, int begin, int end, int target) {
        if (begin > end) return -1;
        else if (data[begin] == target) {
            return begin;
        } else {
            return search(data, begin++, end, target);
        }
    }

    private int searchMax(int[] data, int begin, int end) {
        // begin이 마지막 번호까지 왔을 경우 배열의 마지막 데이터 반환
        if (begin == end) return data[begin];
        else {
            return Math.max(data[begin], searchMax(data, begin++, end));
        }
    }

    @Override
    public void start() {

        String[] tmp = {"abc", "bcd", "cde"};// 4 - 7
        System.out.println(tmp[1].compareTo("bcg"));

    }

}
