package chap02.array.basic;

public class CloneArray {

    public void CloneMethod(int[] original) {

        int[] copy = original.clone();

        this.print(copy);

        copy[3] = 0;

        this.print(copy);

        this.print(original);

    }

    private void print(int[] array) {
        for (int element : array) {
            System.out.println(element);
        }
        System.out.println("----------");
    }

}
