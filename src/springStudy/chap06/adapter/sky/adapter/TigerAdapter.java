package springStudy.chap06.adapter.sky.adapter;

import springStudy.chap06.adapter.sky.animal.Animal;
import springStudy.chap06.adapter.sky.animal.Tiger;

public class TigerAdapter implements Animal {

    Animal tiger;

    public TigerAdapter(Tiger tiger){
        this.tiger = tiger;
    }

    @Override
    public void sound() {
        tiger.sound();
    }

    @Override
    public void move() {
        tiger.move();
    }

}
