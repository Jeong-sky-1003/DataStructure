package springStudy.chap06.adapter;

import caseStudy.MyStart;

// 어댑터 패턴 적용
public class ClientAdapter implements MyStart {

    @Override
    public void start() {

        AdapterServiceA asA1 = new AdapterServiceA();
        AdapterServiceB asB1 = new AdapterServiceB();

        asA1.runService();
        asB1.runService();

    }

}

