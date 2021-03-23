package springStudy.chap06.proxy.client;

import caseStudy.MyStart;
import springStudy.chap06.proxy.service.Service;

public class ClientWithNoProxy implements MyStart {

    @Override
    public void start() {

        Service service = new Service();
        System.out.println(service.runSomething());

    }

}


