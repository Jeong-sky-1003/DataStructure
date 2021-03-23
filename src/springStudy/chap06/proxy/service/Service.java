package springStudy.chap06.proxy.service;

import springStudy.chap06.proxy.IService;

public class Service implements IService {

    @Override
    public String runSomething() {
        return "오픽 무야호~";
    }

}


