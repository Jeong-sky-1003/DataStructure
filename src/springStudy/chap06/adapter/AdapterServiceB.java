package springStudy.chap06.adapter;

public class AdapterServiceB {

    ServiceB serviceB = new ServiceB();

    void runService(){
        serviceB.runServiceB();
    }

}

