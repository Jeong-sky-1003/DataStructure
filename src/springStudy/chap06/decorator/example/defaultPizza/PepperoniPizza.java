package springStudy.chap06.decorator.example.defaultPizza;

import springStudy.chap06.decorator.example.menu.Pizza;

public class PepperoniPizza extends Pizza {

    public PepperoniPizza(){
        super();
        this.menu = "페퍼로니 피자";
    }

    @Override
    public int getPrice() {
        return 5000;
    }

}



