package chap02.array.basic;

public class CardConvRev {

    private int index = 0;
    private final static String DCHAR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // 2진수 ~ 32진수까지 표현하기 위해 미리 String 선언

    private ReverseArray reverseArray;

    public CardConvRev() {
        reverseArray = new ReverseArray();
    }

    public char[] cardConvR(int number, int r, char[] result) {

        int calculate = number % r;
        number /= r;

        result[index++] = DCHAR.charAt(calculate);

        if (number != 0) {
            cardConvR(number, r, result);
        } else {
            reverseArray.reverseArray(result);
            return result;
        }

        return result;

    }

}
