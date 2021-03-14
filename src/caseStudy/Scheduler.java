package caseStudy;

import caseStudy.common.MyDate;
import caseStudy.common.MyEvent;
import caseStudy.event.DeadlinedEvent;
import caseStudy.event.DurationEvent;
import caseStudy.event.OneDayEvent;

import java.util.ArrayList;
import java.util.List;

public class Scheduler implements MyStart{

    // MyEvent를 부모 클래스로 하여 상속하기에
    // 데이터 타입을 MyEvent로 선언할 때 문제 없음 (polymorphism)
    List<MyEvent> events = new ArrayList<>();
    MyEvent []myEvents = new MyEvent[10];

    // 스케줄러 제어
    public void processCommand(){

        while (true){

            System.out.print("$ ");
            String command = sc.next();

            if(command.equals("addevent")){

                // 이벤트 추가 속성
                // 대소문자 구분 없이 비교하기
                String type = sc.next();

                // 방법 1. 입력 받은 값을 toLowerCase()로 소문자로 변환
                // type = type.toLowerCase();

                // 방법 2. 비교시 equalsIgnoreCase() 이용
                if (type.equalsIgnoreCase("oneday")){
                    handleAddOneDayEvent();
                } else if (type.equalsIgnoreCase("duration")){
                    handleAddDurationEvent();
                } else if (type.equalsIgnoreCase("deadline")){
                    handleAddDeadlinedEvent();
                } else {
                    System.out.println("$ type. wrong command");
                }

            } else if (command.equals("list")){
                handleList();
            } else if (command.equals("show")){
                handleShow();
            } else if (command.equals("exit")){
                break;
            } else {
                System.out.println("$ info. wrong command");
            }

        }

        sc.close();

    }

    // 배열 크기가 부족할 경우
    // ArrayList가 아닌 배열 사용시
    private void reallocate(){
        // 두 배 크기의 배열 생성
        MyEvent []tmpArray = new MyEvent[myEvents.length * 2];
        // 기존 배열의 데이터를 임시 배열에 복사
        tmpArray = myEvents.clone();
        // myEvents의 참조 주소를 tmpArray로 변경해 배열 크기 증가
        myEvents = tmpArray;
    }

    // 입력한 날짜에 존재하는 이벤트 출력
    private void handleShow() {

        System.out.print("  search: ");

        String dateStr = sc.next();
        MyDate myDate = this.setMyDate(dateStr);

        for (int i=0; i < events.size(); i++){

            if ( events.get(i).isRelevant(myDate) )
                System.out.println( events.get(i).toString() );

        }

    }

    // 입력된 모든 이벤트 출력
    private void handleList() {

        for(int i=0; i < events.size(); i++){
            String tmp = events.get(i).toString();
            System.out.println( "  " + tmp );
        }

    }

    // dead line 이벤트 추가
    private void handleAddDeadlinedEvent() {

        System.out.print("  when: ");

        // 날짜 받기
        String dateString = sc.next();
        MyDate deadline = this.setMyDate(dateString);

        System.out.print("  title: ");
        // 띄어쓰기를 값으로 받고 싶은 경우 먼저 위 출력 글씨를 개행한 다음 값을 받아야 함
        sc.next();
        String title = sc.nextLine();

        events.add(new DeadlinedEvent(title, deadline));

    }

    // duration event 추가
    private void handleAddDurationEvent() {

        System.out.print("  begin: ");

        // 날짜 받기
        String begin_str = sc.next();
        MyDate begin = this.setMyDate(begin_str);

        System.out.print("  end: ");
        String end_str = sc.next();
        MyDate end = this.setMyDate(end_str);

        System.out.print("  title: ");
        sc.next();
        String title = sc.nextLine();

        events.add(new DurationEvent(title, begin, end));

    }

    // oneday 이벤트 추가
    private void handleAddOneDayEvent() {

        System.out.print("  when: ");

        // 날짜 받기
        String dateString = sc.next();
        MyDate myDate = this.setMyDate(dateString);

        System.out.print("  title: ");
        sc.next();
        String title = sc.nextLine();

        events.add(new OneDayEvent(title, myDate));

    }

    // MyDate 생성 후 리턴
    private MyDate setMyDate(String dateString){

        String []dateInfo = dateString.split("/");
        /*
            split 나누는 것 필요시 : 정규 표현식(regular expression)이 들어가야함
            만약 온점( . )을 기준으로 split 하고 싶다면
                                                \\.
            으로 입력해야 함
            \(backslash) : escape character
                기존 의미를 빼고 문자열 그대로 인식하게하는 것
            단어간 공백으로 split 할 경우
                str.split("[ ]+");  혹은  str.split("\\s+");
                전자 방법이 좋은 것은 여러 개의 공백일 경우 적절히 적용됨
         */

        int year = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int day = Integer.parseInt(dateInfo[2]);

        return new MyDate(year, month, day);

    }

    @Override
    public void start() {
        processCommand();
    }

}
