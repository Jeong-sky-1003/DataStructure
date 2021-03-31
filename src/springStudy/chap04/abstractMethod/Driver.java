package springStudy.chap04.abstractMethod;

import caseStudy.MyStart;

public class Driver implements MyStart {

    private void run() {

        Animal[] animals = new Animal[2];

        animals[0] = new Cat();
        animals[1] = new Dog();

    }

    @Override
    public void start() throws Exception {
        run();
    }

}

