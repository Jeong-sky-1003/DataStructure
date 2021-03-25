package springStudy.chap06.decorator.example.menu;

public abstract class Pizza {

    protected String menu = "no name";

    // 가격 받기
    public abstract int getPrice();

    // 메뉴 이름 받기
    public String getMenu(){
        return menu;
    }

}


