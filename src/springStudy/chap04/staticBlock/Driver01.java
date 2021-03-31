package springStudy.chap04.staticBlock;

import caseStudy.MyStart;

public class Driver01 implements MyStart {

    private void run() {
        Animal animal = new Animal();
        System.out.println(Animal.age);
    }

    @Override
    public void start() throws Exception {
        run();
    }

}

