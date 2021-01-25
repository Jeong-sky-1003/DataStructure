package chap02.array.multi;

import java.util.Scanner;

public class DayOfYear_Q9 implements MultiArray{

    private Scanner sc;
    private final static
            int[][] days = {
                            {31,28,31,30,31,30,31,31,30,31,30,31},
                            {31,29,31,30,31,30,31,31,30,31,30,31}
                            };

    public DayOfYear_Q9(){
        sc = new Scanner(System.in);
    }

    @Override
    public void start() {

        int continueChk = 0;

        do {

            System.out.print("년: ");
            int year = sc.nextInt();

            System.out.print("월: ");
            int month = sc.nextInt();

            System.out.print("일: ");
            int day = sc.nextInt();

            day = this.leftDayOfYear(year, month, day);
            System.out.printf("그 해의 남은 일은 %d일 입니다.\n", day);

            System.out.print("계속 할까요? 1: 예 , 2: 아니오 ");
            continueChk = sc.nextInt();

        } while (continueChk == 1);

    }

    // 윤년 : 1 , 일반 : 0
    private int monthOfDayChk(int year){
        return ( year%4 == 0 && year%100 != 0 && year%400 == 0 ) ? 1 : 0;
    }

    // 그 해 경과일수 구하기
    private int dayOfYear(int year, int month, int day){

        int x = this.monthOfDayChk(year);
        int[] daysArray = days[x];

        int index = 0;
        while (index < month - 1){
            day = day + daysArray[index++];
        }

        return day;

    }

    // 그 해의 남은 일수 구하기
    private int leftDayOfYear(int year, int month, int day){

        int x = this.monthOfDayChk(year);
        int[] daysArray = days[x];

        int index = 0;
        while (index < month - 1){
            day = day + daysArray[index++];
        }

        int totalDay = 0;
        for (int element : daysArray){
            totalDay += element;
        }

        return totalDay - day;

    }

}
