package springStudy.chap04.finalKeyword;

public class Cat {

    final static int s_var1 = 1;
    final static int s_var2;

    final int var1 = 1;
    final int var2;

    static {
        s_var2 = 2;
        // 상수는 한 번 초기화되면 값 변경이 불가함
        // s_var2 = 4;
    }

    Cat() {

        var2 = 2;
        // var = 4;

        final int l_var1 = 1;
        final int l_var2;

        l_var2 = 2;

    }

}


