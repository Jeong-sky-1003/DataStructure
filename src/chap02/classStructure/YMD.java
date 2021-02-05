package chap02.classStructure;

import java.util.Scanner;

// 93 page - 연습문제 11번
public class YMD implements ClassStructure{

    int y;
    int m;
    int d;

    private Scanner sc;
    private int dayListIndex;

    private final int[][] dayList = {
                                    {31,28,31,30,31,30,31,31,30,31,30,31},  // 평년
                                    {31,29,31,30,31,30,31,31,30,31,30,31},  // 윤년
                                    };

    public YMD(){
        sc = new Scanner(System.in);
    }

    // 생성자 1: 주어진 날짜로 설정
    public YMD(int y, int m, int d){
        this.y = y;
        this.m = m;
        this.d = d;
        dayListIndex = this.chkLeap(y);
    }

    // 평년 윤년 체크
    private int chkLeap(int y){
        return ( (y%4 == 0) && (y%100 != 0) || (y%400 == 0) ) ? 1:0 ;
    }

    // 재귀함수 적용
    // 반복이 필요한 부분을 따로 분리해 재귀함수 적용
    private YMD getAfterResult(int n){

        int tmp = dayList[dayListIndex][this.m - 1] - this.d;

        if (n > tmp){
            n -= (tmp);
            this.m++;
            this.d = 0;
            this.getAfter(n);
        } else {
            this.d += n - 1;
        }

        return new YMD(this.y, this.m, this.d);

    }

    public YMD getAfter(int n){

        // 연 단위 판단으로 반복 횟수 감소 시킬 수 있음
        if (n > 365){
            this.y += (n/365);
            n %= 365;
            dayListIndex = this.chkLeap(this.y);
        }

        return this.getAfterResult(n);

        // 인터넷 속 정답
        // 동일 연산의 적절한 위치 선정이 애매함
//        int tmp = dayList[dayListIndex][this.m - 1] - this.d;
//
//        while (n > tmp){
//
//            n -= (tmp);
//            this.m++;
//            this.d = 0;
//            this.getAfter(n);
//
//            tmp = dayList[dayListIndex][this.m - 1] - this.d;
//
//        }
//
//        this.d += n - 1;
//        return new YMD(this.y, this.m, this.d);

        // 정답에 재귀함수 적용
        // 반복이 불필요한 코드의 반복으로 재귀함수 부분을 메서드로 따로 분리
//        if (n > 365){
//            this.y += (n/365);
//            n %= 365;
//            dayListIndex = this.chkLeap(this.y);
//        }

//        if (n > tmp){
//            n -= (tmp);
//            this.m++;
//            this.d = 0;
//            this.getAfter(n);
//        } else {
//            this.d += n - 1;
//        }
//
//        return new YMD(this.y, this.m, this.d);

        // 하늘 풀이
//        this.d = this.d + n;
//        if( this.d > thisMonthDays ){
//
//            // 1개월 초과로 한 달 증가
//            this.m += 1;
//            // 계산하고 남은 일수 구하기
//            n = this.d - thisMonthDays;
//            // 데이 초기화
//            this.d = 0;
//
//            // 월이 12를 넘길 경우 연은 1추가 후 월은 1로 초기화
//            if (this.m > 12){
//                this.m = 1;
//            }
//            this.getAfter(n);
//
//        } else {
//            this.d -= 1;
//        }
//
//        result = new YMD(this.y, this.m, this.d);

    }

    private YMD getBeforeResult(int n){

        

    }

    public YMD getBefore(int n){

        // 먼저 n이 연단위인지 체크
        if( n > 365){
            this.y -= (n/365);
            n %= 365;
            dayListIndex = this.chkLeap(this.y);
        }
        // 연단위일 그만큼 연 마이너스 진행
        // 이후 나머지 값으로 -y년 전의 m월 d일부터 전일 계산

        // 무조건 한 번은 계산해야 하기에 전일로 구하고자 하는 값을 계산할 날짜에서 빼줌
        this.d = this.d - n;

        // 마이너스로 계산이 됐다는 것은 한 달을 초과했다는 것.
        if ( this.d < 0 ){

            this.m -= 1;
            if (this.m < 1){
                this.m = 12;
                this.y--;
                this.dayListIndex = this.chkLeap(this.y);
            }

            int thisMonthDays = dayList[this.dayListIndex][this.m - 1];
            n = -this.d;
            this.d = thisMonthDays;
            this.getBefore(n);

        }

        return new YMD(this.y, this.m, this.d);

    }

    @Override
    public void start() {

        System.out.print("year: ");
        this.y = sc.nextInt();

        System.out.print("month: ");
        this.m = sc.nextInt();

        System.out.print("day: ");
        this.d = sc.nextInt();

        YMD ymd = new YMD(y,m,d);

        System.out.print("실행 계산 [1: after / 2: before] : ");
        int choose = sc.nextInt();

        if (choose == 1){
            System.out.print("며칠 후를 알고 싶나요? ");
            choose = sc.nextInt();
            ymd = ymd.getAfter(choose);
        } else {
            System.out.print("며칠 전을 알고 싶나요? ");
            choose = sc.nextInt();
            ymd = ymd.getBefore(choose);
        }

        System.out.println(ymd.y + "/" + ymd.m + "/" + ymd.d);

    }

}
