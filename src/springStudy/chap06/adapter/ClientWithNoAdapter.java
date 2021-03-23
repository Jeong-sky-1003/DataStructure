package springStudy.chap06.adapter;

import caseStudy.MyStart;

public class ClientWithNoAdapter implements MyStart {

    @Override
    public void start() {

        ServiceA sa1 = new ServiceA();
        ServiceB sb1 = new ServiceB();

        sa1.runServiceA();
        sb1.runServiceB();

    }

}

