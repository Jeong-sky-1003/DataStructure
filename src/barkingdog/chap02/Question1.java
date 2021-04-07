package barkingdog.chap02;

import caseStudy.MyStart;

import java.util.ArrayList;

public class Question1 implements MyStart {

    @Override
    public void start() throws Exception {
        String str = "12";
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println("함수 실행 전: " + list.get(0));
        test(list);
        System.out.println("함수 실행 후: " + list.get(0));
    }

    private void test(ArrayList<Integer> list) {
        list.set(0, 5);
    }

}
