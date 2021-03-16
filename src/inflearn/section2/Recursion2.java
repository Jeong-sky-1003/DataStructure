package inflearn.section2;

import inflearn.Inflearn;

public class Recursion2 implements Inflearn {

    private int length(String str){
        // 만약 자른 String이 "" (공백)을 마주할 경우 0을 return
        System.out.println(str);
        if (str.equals("")) return 0;
        else {
            // substring(1)로 String의 index번호 1번부터 자름
            return 1 + length(str.substring(1));
        }
    }

    private void printStr(String str){
        // str의 길이가 0일 경우 출력할 값이 없기에 return
        if (str.length() == 0) return;
        else {
            // 첫 문자를 출력한 뒤
            System.out.println(str.charAt(0));
            // 다음 문자열부터 잘라 넘겨줄것
            printStr(str.substring(1));
        }
    }

    private void printReverseStr(String str){

        if (str.length() == 0) return;
        else {
            // 재귀는 호출하며 메모리에 할당되며 base case를 만나면 할당된 역순으로 실행됨
            printReverseStr(str.substring(1));
            System.out.println(str.charAt(0));
        }

    }

    private void printBinary(int n){
        if (n < 2) System.out.print(n);
        else {
            // 이진법은 계산된 역순으로 출력되기에 먼저 재귀함수를 호출함
            // 이진수의 몫 계산
            printBinary(n/2);
            System.out.print(n%2);
        }
    }

    // n: list 총 갯수
    private int arraySum(int n, int[] list){
        // 모든 리스트를 순회한 경우 0을 리턴함
        if (n <= 0) return 0;
        else {
            return arraySum(n-1, list) + list[n-1];
        }
    }

    // scanner로 n개의 정수를 입력 받아 배열 data에 저장
    private void readFrom(int n, int[] data){
        if (n <= 0) return;
        else {
            readFrom(n-1, data);
            data[n-1] = sc.nextInt();
        }
    }

    @Override
    public void start() {

        // 15 --> 1111
        // this.printBinary(15);
        int []datas = new int[5];
        this.readFrom(5, datas);
        for (int e:datas)
            System.out.println(e);

    }

}
