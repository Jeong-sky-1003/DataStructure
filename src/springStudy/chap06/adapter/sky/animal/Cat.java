package springStudy.chap06.adapter.sky.animal;

public class Cat implements Animal {

    @Override
    public void sound() {
        System.out.println("야옹~~~~");
    }

    @Override
    public void move() {
        System.out.println("총총총총");
    }

}
