package springStudy.chap04.thisKeyword;

import caseStudy.MyStart;

class Cat{
    int var = 10;
    void test(){
        int var = 20;
        System.out.println("var: " + var);
        System.out.println("this.var: " + this.var);
    }
}

public class Driver implements MyStart {
    @Override
    public void start() throws Exception {
        Cat cat = new Cat();
        cat.test();
    }
}


