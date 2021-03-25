package springStudy.chap06.proxy.book.client;

import caseStudy.MyStart;
import springStudy.chap06.proxy.book.IService;
import springStudy.chap06.proxy.book.Proxy;

public class ClientWithProxy implements MyStart{

    @Override
    public void start() {
        IService iService = new Proxy();
        System.out.println(iService.runSomething());
    }

}
