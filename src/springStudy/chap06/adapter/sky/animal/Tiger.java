package springStudy.chap06.adapter.sky.animal;

public class Tiger implements Animal {

    @Override
    public void sound() {
        System.out.println("어흥!!");
    }

    @Override
    public void move() {
        System.out.println("터벅 터벅 터벅");
    }

}
