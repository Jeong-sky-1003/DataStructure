package springStudy.chap06.proxy.book.service;

import springStudy.chap06.proxy.book.IService;

public class Service implements IService {

    @Override
    public String runSomething() {
        return "오픽 무야호~";
    }

}


