package springStudy.chap06.decorator.book.service;

import springStudy.chap06.decorator.book.IService;

public class Service implements IService {

    @Override
    public String runSomething() {
        return "데코레이터 패턴";
    }

}

