package springStudy.chap04.constructor;

import caseStudy.MyStart;

public class Driver implements MyStart {

    private void run() {
        Animal animal = new Animal();
        animal = null;
        animal = new Animal("cat");
    }

    @Override
    public void start() throws Exception {
        run();
    }

}




