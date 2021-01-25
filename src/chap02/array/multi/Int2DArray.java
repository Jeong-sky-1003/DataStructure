package chap02.array.multi;

public class Int2DArray implements MultiArray{

    @Override
    public void start() {

        int[][] x = new int[2][3];

        x[0][1] = 20;
        x[1][1] = 30;
        x[1][2] = 40;

        // x는 int[]를 자료형으로 가지며
        for (int[] elementX : x){
            // elementX는 int를 자료형으로 가짐
            for (int element : elementX){
                System.out.print(element + "\t");
            }
            System.out.println();
        }

    }

}
