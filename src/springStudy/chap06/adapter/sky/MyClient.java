package springStudy.chap06.adapter.sky;

import caseStudy.MyStart;
import springStudy.chap06.adapter.sky.adapter.CatAdapter;
import springStudy.chap06.adapter.sky.adapter.TigerAdapter;
import springStudy.chap06.adapter.sky.animal.Animal;
import springStudy.chap06.adapter.sky.animal.Cat;
import springStudy.chap06.adapter.sky.animal.Tiger;

public class MyClient implements MyStart {

    @Override
    public void start() throws Exception {

        Animal catAdapter = new CatAdapter(new Cat());
        Animal tigerAdpater = new TigerAdapter(new Tiger());

        catAdapter.move();
        catAdapter.sound();

        System.out.println("---------------------");

        tigerAdpater.move();
        tigerAdpater.sound();

    }

}
