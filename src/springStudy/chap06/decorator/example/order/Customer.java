package springStudy.chap06.decorator.example.order;

import caseStudy.MyStart;
import springStudy.chap06.decorator.example.defaultPizza.CheesePizza;
import springStudy.chap06.decorator.example.defaultPizza.PepperoniPizza;
import springStudy.chap06.decorator.example.menu.CondimentDecorator;
import springStudy.chap06.decorator.example.menu.Pizza;
import springStudy.chap06.decorator.example.topping.CheeseCrust;
import springStudy.chap06.decorator.example.topping.Olive;

public class Customer implements MyStart {

    private CondimentDecorator getTopping(int menu, Pizza pizza){

        if (menu == 1){
            return new Olive(pizza);
        } else {
            return new CheeseCrust(pizza);
        }

    }

    @Override
    public void start() throws Exception {

        Pizza pizza = null;
        CondimentDecorator decorator = null;

        System.out.println("무엇을 주문하시겠습니까? (1) 치즈피자 (2) 페퍼로니 피자");
        int menu  = sc.nextInt();

        switch (menu){

            case 1:

                pizza = new CheesePizza();

                System.out.println("토핑을 추가하시겠습니까? (1) 올리브 (2) 치즈크러스트 (3) 없음");
                menu = sc.nextInt();
                if (menu < 3)
                    decorator = this.getTopping(menu, pizza);
                break;

            case 2:

                pizza = new PepperoniPizza();

                System.out.println("토핑을 추가하시겠습니까? (1) 올리브 (2) 치즈크러스트 (3) 없음");
                menu = sc.nextInt();

                if (menu < 3)
                    decorator = this.getTopping(menu, pizza);

                break;

            default:
                break;

        }

        if (decorator != null)
            System.out.printf( "주문 메뉴: %s, 가격: %d", decorator.getMenu(), decorator.getPrice() );
        else
            System.out.printf("주문 메뉴: %s, 가격: %d", pizza.getMenu(), pizza.getPrice());

    }

}
