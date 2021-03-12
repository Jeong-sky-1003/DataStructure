package chap06.sort;

import chap06.Chap06;

public class BubbleSort implements Chap06 {

    private int[] array;

    // 비교횟수
    private int count;
    // 교환 횟수
    private int change_count;

    // 거품정렬
    /**
     * array : 정렬할 배열
     * capacity : 요소 수
     */
    private void bubSort(int[] array, int capacity){
        String op = "";
        for (int i = 0; i < capacity - 1; i++) {
            // 패스
            // 끝부터 앞으로 비교하며 정렬함
            for (int j = capacity - 1; j > i; j--) {
                count++;
                if (array[j - 1] > array[j]) {
                    change_count++;
                    printDetail(array, j, "+");
                    op = "+";
                    swap(array, j - 1, j);
                } else {
                    printDetail(array, j, "-");
                    op = "-";
                }
            }
            System.out.println("----------------------------------");
        }

    }

    private void bubSortVer2(int[] array, int capacity){
        String op;
        // 앞에서 끝으로 비교하며 정렬함
        for (int i = capacity-1; i > 0; i--){
            // 한 번 비교한 값이 앞에 위치한 값보다 작을 가능성이 있기에 이중 반복문
            for (int j = 0; j < i; j++){
                count++;
                if (array[j] > array[j+1]){
                    printDetail(array, j+1, "+");
                    change_count++;
                    op = "+";
                    swap(array, j, j+1);
                } else {
                    op = "-";
                    printDetail(array, j+1, "-");
                }

            }
            System.out.println("---------------------");
        }

    }

    // 앞에 위치한 값과 교환하는 메서드
    private void swap(int[] array, int idx1, int idx2){
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    private int[] arrayMake(int capacity){
        return new int[capacity];
    }

    private void arrayEnter(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d]: ", i);
            array[i] = sc.nextInt();
        }
    }

    private void print(){
        System.out.println("-------------------\n오름차순 완료");
        for (int i = 0; i < array.length; i++){
            System.out.printf("x[%d]: %d\n", i, array[i]);
        }
    }

    // 교환과정을 상세하게 진행
    private void printDetail(int[] array, int change, String op){
        for (int i=0; i < array.length; i++){
            if (change == i) System.out.printf("%s", op);
            System.out.printf("%3d", array[i]);
        }
        System.out.println();
    }

    @Override
    public void start() {

        System.out.print("요소 수: ");

        int capacity = sc.nextInt();
        array = this.arrayMake(capacity);
        arrayEnter(array);

        bubSort(array, capacity);
//        print();
        System.out.printf("비교: %d회, 교환: %d회", count, change_count);

    }

}
