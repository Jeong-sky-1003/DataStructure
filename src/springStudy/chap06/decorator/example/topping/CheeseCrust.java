package springStudy.chap06.decorator.example.topping;

import springStudy.chap06.decorator.example.menu.CondimentDecorator;
import springStudy.chap06.decorator.example.menu.Pizza;

public class CheeseCrust extends CondimentDecorator {

    Pizza pizza;

    public CheeseCrust(Pizza pizza){
        super();
        this.pizza = pizza;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 3000;
    }

    @Override
    public String getMenu() {
        return "치즈 크러스트를 토핑한 " + pizza.getMenu();
    }

}


