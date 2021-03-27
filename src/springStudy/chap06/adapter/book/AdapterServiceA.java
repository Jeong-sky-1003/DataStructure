package springStudy.chap06.adapter.book;

// ServiceA의 변환기
public class AdapterServiceA {

    // 접근하고자 하는 참조 변수 선언
    ServiceA sa1 = new ServiceA();

    // 접근한 참조 변수의 메서드를 실행하기 위한 메서드
    void runService() {
        sa1.runServiceA();
    }

}


