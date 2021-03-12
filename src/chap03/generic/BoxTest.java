package chap03.generic;

import chap03.Chapter03;

public class BoxTest implements Chapter03 {

    private Box<Integer> box_int;
    private Box<String> box_str;

    @Override
    public void start() {

        // Generic 클래스를 생성할 때 타입 T를 실제하는 타입으로 지정
        // < > : 생략 가능
        box_int = new Box();

        // box는 generic class로 할당 데이터 타입에 제한이 존재하지 않음
        box_int.set(new Integer(20));
        System.out.printf("first: %d\n", box_int.get());

        box_int.set(new Integer(10));
        System.out.printf("second: %d\n", box_int.get());

        box_str = new Box<String>();

        box_str.set(new String("sky"));
        System.out.printf("third: %s", box_str.get());

    }

}


