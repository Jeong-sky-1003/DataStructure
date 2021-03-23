package springStudy.chap06.decorator.decorator;

import springStudy.chap06.decorator.IService;
import springStudy.chap06.decorator.service.Service;

public class Decorator implements IService {

    IService service;

    @Override
    public String runSomething() {

        service = new Service();
        System.out.println("데코레이터도 마찬가지로 서비스 수행 전 후 다른 로직 처리 가능");

        return service.runSomething() + " 무릎 아프당";

    }

}

