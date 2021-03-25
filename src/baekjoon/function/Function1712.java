package baekjoon.function;

import baekjoon.BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Function1712 implements BackJoon {

    private void run2() throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        // 고정비
        double a = Double.parseDouble( string.split(" ")[0] );
        // 유동비
        double b = Double.parseDouble( string.split(" ")[1] );

        // 가격
        double price = Double.parseDouble( string.split(" ")[2] );

        if ( price <= b ){
            System.out.println(-1);
        } else {

            // 회계상 손익분기점 계산식: a / ( 1 - ( b / price ) )
            int result =  (int) ( a / (price - b) ) + 1 ;
            System.out.println(result);

        }

    }

    // 시간제한: 0.35초, 시간초과
    private void run() throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        // 고정비
        int a = Integer.parseInt( string.split(" ")[0] );
        // 유동비
        int b = Integer.parseInt( string.split(" ")[1] );

        // 가격
        int price = Integer.parseInt( string.split(" ")[2] );

        int profit = price - (a+b);
        int count = 1;

        while (true){

            count++;
            int tmp = ( price * count ) - ( a + (b * count) );
            if ( tmp < profit ) {
                count = -1;
                break;
            }

            if ( tmp > 0 ) {
                break;
            }

        }

        System.out.println(count);

    }

    @Override
    public void start() throws Exception {
        run2();
    }

}
