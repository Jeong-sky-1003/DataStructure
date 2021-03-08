package chap03.queue;

public class IntAryQueue {

    private int max;    // 큐 용량
    private int num;    // 현 데이터 수
    private int[] que;  // 큐 본체

    // 생성자 : 초기화
    public IntAryQueue(int capacity){

        this.max = capacity;
        this.num = 0;

        try{
            que = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }

    }

    public static class EmptyQueueException extends RuntimeException{
        public EmptyQueueException() {}
    }

    public static class OverFlowQueueException extends RuntimeException{
        public OverFlowQueueException() {}
    }

    // 인큐: 데이터 삽입 작업
    public int enqueue(int x) throws OverFlowQueueException{
        if (num >= max) throw new OverFlowQueueException();
        return que[num++] = x;
    }

    // 디큐: 데이터 꺼내는 작업
    public int dequeue() throws EmptyQueueException{

        if (num <= 0) throw new EmptyQueueException();
        int result = que[0];

        for (int i = 0; i < num - 1; i++){
            que[i] = que[i + 1];
        }
        num--;

        return result;

    }

    // 덤프: 데이터 출력
    public void dump() throws EmptyQueueException{
        if (num <= 0) throw new EmptyQueueException();
        for (int i = 0; i < num; i++){
            System.out.print(que[i] + " ");
        }
        System.out.println();
    }

}
