package springStudy.chap06.decorator.example.topping;

import springStudy.chap06.decorator.example.menu.CondimentDecorator;
import springStudy.chap06.decorator.example.menu.Pizza;

public class Olive extends CondimentDecorator {

    Pizza pizza;

    public Olive(Pizza pizza){
        super();
        this.pizza = pizza;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 500;
    }

    @Override
    public String getMenu() {
        return "올리브 " + pizza.getMenu();
    }

}

