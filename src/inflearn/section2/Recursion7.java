package inflearn.section2;

import caseStudy.MyStart;

public class Recursion7 implements MyStart {

    // 전체 집합
    private static char[] s_list = {'a', 'b', 'c', 'd', 'e', 'f'};
    private static int n = s_list.length;
    private static boolean[] include = new boolean[n];

    private void powerSet(int k) {

        // 처음 이 함수를 호출할 때 powerSet(0)으로 호출함
        // 이 뜻은 합집합을 나타내는 p_list는 공집합이라는 뜻임
        // k와 include 배열은 트리상 현재 나의 위치를 표현함

        /*
            s_list: k번부터 마지막 원소까지 연속된 원소들
            p_list: 처음부터 k-1번째 원소들 중 일부

            이를 표현하기 위해 boolean 배열 활용

            k를 기준으로 k ~ 마지막 요소까지는 집합 S(전체집합)에 해당하며,
            k를 기준으로 0 ~ k - 1 요소까지 중 true인 데이터가 집합 P(합집합)에 해당함

            k의 일은 집합 S의 모든 집합을 구해, 집합 P 영역에서 true인 부분들의 요소를
            포함해 화면에 출력하는 것임

            p_list 의 집합 조합을 나타내기 위해 index를 true/false로 체크하여
            boolean 배열의 true로 되어있는 index 위치의 p_list를 출력
         */

        System.out.printf("k: %d\n", k);

        // 실행 과정 체크하기 위한 코드
        /*
        for (int j=0; j < n; j++)
            System.out.print( include[j] + " " );
        System.out.println();
         */

        // base case : 집합 S가 공집합인 경우를 이야기 함
        // k는 합집합 원소의 범위를 나타내는 기준으로 만약 k가 배열의 크기까지 도달했을 경우 출력
        if (k == n) {
            System.out.println("----------------------------------------");
            for (int i = 0; i < n; i++) {
                // 만약 boolean index 번호가 true라면 해당 요소 출력
                if (include[i]) System.out.print(s_list[i] + " ");
            }
            System.out.println("\n----------------------------------------");
            return;
        }

        // k값이 n보다 작을 경우
        // (1) s_list[k]를 포함하지 않는 부분집합을 출력하기 위한 것
        include[k] = false;
        // k+1을 해줌으로 집합 S의 범위 재정의
        // 트리의 왼쪽으로 내려감
        powerSet(k + 1);

        // (2) s_list[k]가 포함된 부분집합의 경우를 출력하기 위한 것
        // 트리의 오른쪽으로 내려감
        include[k] = true;
        powerSet(k + 1);

    }

    @Override
    public void start() throws Exception {
        powerSet(0);
    }

}
