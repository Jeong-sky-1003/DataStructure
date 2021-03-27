package springStudy.chap06.adapter.sky.adapter;

import springStudy.chap06.adapter.sky.animal.Animal;
import springStudy.chap06.adapter.sky.animal.Cat;

public class CatAdapter implements Animal {

    Animal cat;

    public CatAdapter(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void sound() {
        cat.sound();
    }

    @Override
    public void move() {
        cat.move();
    }

}
