package springStudy.chap06.singleton.example;

import caseStudy.MyStart;

public class Manage implements MyStart {

    @Override
    public void start() throws Exception {

        Manager manager = Manager.getManager();

        PartTime[] partTimes = new PartTime[5];
        for (int i=0; i < 5; i++){

            PartTime partTime = new PartTime("partTime " + i);
            partTime.setInterview("interview " + i);

            partTimes[i] = partTime;

        }

        for (int j=0; j < 5; j++)
            System.out.println(partTimes[j].toString());

    }

}

