package springStudy.chap04.interfaceKeyword;

import caseStudy.MyStart;

interface Speakable {

    double PI = 3.14159;
    final double absoluteZeroPoint = -275.15;

    void say();

}

class Speaker implements Speakable {
    @Override
    public void say() {
        System.out.println("say");
    }
}

public class Driver implements MyStart {

    @Override
    public void start() throws Exception {

        System.out.println(Speakable.absoluteZeroPoint);
        System.out.println(Speakable.PI);


        Speaker speaker = new Speaker();
        speaker.say();

    }

}
