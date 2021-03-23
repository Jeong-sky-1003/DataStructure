package springStudy.chap06.proxy.client;

import caseStudy.MyStart;
import springStudy.chap06.proxy.IService;
import springStudy.chap06.proxy.Proxy;

public class ClientWithProxy implements MyStart{

    @Override
    public void start() {
        IService iService = new Proxy();
        System.out.println(iService.runSomething());
    }

}
