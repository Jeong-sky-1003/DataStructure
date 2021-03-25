package springStudy.chap06.proxy.book;

import springStudy.chap06.proxy.book.service.Service;

public class Proxy implements IService{

    // 여기서 중요한 포인트는 Proxy는 Service의 메서드를 대변한다는 것
    IService iService;

    @Override
    public String runSomething() {

        // proxy 실행 중 다른 로직 수행이 가능함
        System.out.println("proxy 접근");
        // 즉, proxy의 주 목적은 호출에 대한 흐름 제어이며
        // 결과 값은 그대로 반환하는 것임

        iService = new Service();
        return iService.runSomething();

    }

}


