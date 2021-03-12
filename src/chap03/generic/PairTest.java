package chap03.generic;

import chap03.Chapter03;

public class PairTest implements Chapter03 {

    private Pair<String, Integer> pair_1;
    private Pair<String, String> pair_2;

    @Override
    public void start() {

        pair_1 = new Pair<>();
        pair_2 = new Pair<>();

        pair_1.setKV("sky", 26);
        pair_2.setKV("sky", "juhae");

        System.out.printf("key: %s value: %d\n", pair_1.getKey(), pair_1.getValue());
        System.out.printf("key: %s value: %s", pair_2.getKey(), pair_2.getValue());

    }

}
