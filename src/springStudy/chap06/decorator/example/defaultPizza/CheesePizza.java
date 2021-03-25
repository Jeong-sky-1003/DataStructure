package springStudy.chap06.decorator.example.defaultPizza;

import springStudy.chap06.decorator.example.menu.Pizza;

public class CheesePizza extends Pizza {

    public CheesePizza() {
        super();
        menu = "치즈피자";
    }

    @Override
    public int getPrice() {
        return 6000;
    }

}


