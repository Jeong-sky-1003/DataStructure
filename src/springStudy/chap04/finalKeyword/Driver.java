package springStudy.chap04.finalKeyword;

import caseStudy.MyStart;

class Animal {

}

class Bird extends Animal{

}

class Penguin extends Bird {

}

public class Driver implements MyStart {

    @Override
    public void start() throws Exception {

        Animal animal = new Animal();
        Animal bird = new Bird();
        Animal penguin = new Penguin();

        System.out.println(animal instanceof Animal);

        System.out.println(bird instanceof Animal);
        System.out.println(bird instanceof Bird);

        System.out.println(penguin instanceof Animal);
        System.out.println(penguin instanceof Bird);
        System.out.println(penguin instanceof Penguin);

        System.out.println(penguin instanceof Object);

    }

}
