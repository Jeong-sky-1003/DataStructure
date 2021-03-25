package springStudy.chap06.proxy.book.client;

import caseStudy.MyStart;
import springStudy.chap06.proxy.book.service.Service;

public class ClientWithNoProxy implements MyStart {

    @Override
    public void start() {

        Service service = new Service();
        System.out.println(service.runSomething());

    }

}


