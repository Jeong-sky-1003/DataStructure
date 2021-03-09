package chap03.queue;

public class IntRingBufferQueue {

    private int max;    // 용량 ( = 최대 요소 갯수 )
    private int front;  // 첫 번째 요소 index 번호
    private int rear;   // 마지막 요소 index 번호
    private int num;    // 현제 데이터 수
    private int[] que;

    public IntRingBufferQueue(int capacity){

        this.max = capacity;
        this.num = this.front = this.rear = 0;

        try{
            que = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }

    }

    public static class EmptyRingBufferQueueException extends RuntimeException{
        public EmptyRingBufferQueueException() {}
    }

    public static class OverFlowRingBufferQueueException extends RuntimeException{
        public OverFlowRingBufferQueueException() {}
    }

    // isFull: 꽉 찼는지 확인
    public boolean isFull(){
        return (num >= max);
    }

    // isEmpty: 비었는지 확인
    public boolean isEmpty(){
        return (num <= 0);
    }

    // size: 데이터 수 확인
    public int size(){
        return num;
    }

    // capacity: 큐 용량 반환
    public int capacity(){
        return max;
    }

    // 클리어: 모든 큐 삭제
    public void clear() {
        num = front = rear = 0;
    }

    // 피크: 맨 처음 데이터 들여다 보기
    public int peek() throws EmptyRingBufferQueueException{
        if (num <= 0) throw new EmptyRingBufferQueueException();
        return que[front];
    }

    // indexOf: 큐에서 값 검색하기
    public int indexOf(int x) throws EmptyRingBufferQueueException{

        if (num <= 0) throw new EmptyRingBufferQueueException();

        for (int i = 0; i < num; i++){
            /*
                i로만 활용할 경우 0번 부터 max-1 번호까지 순환되어 불필요한 동작이 증가함
                이에 규칙을 찾아 적용한 것임
                이해가 안간다면 링 버퍼 큐의 검색 Index 번호 계산 = ( i + front ) % max
             */
            int index = (i + front) % max;
            if (que[index] == x) return index - (front - 1);
        }

        return 0;

    }

    // 인큐: 값 삽입
    public int enqueue(int x) throws OverFlowRingBufferQueueException{

        if (max <= num) throw new OverFlowRingBufferQueueException();

        que[rear++] = x;
        num++;

        // IndexOfOutBoundException 방지
        if (max == rear) rear = 0;
        return x;

    }

    // 디큐: 값 꺼내기
    public int dequeue() throws EmptyRingBufferQueueException{

        if (num <= 0) throw new EmptyRingBufferQueueException();

        int result = que[front++];
        num--;

        if (front == max) front = 0;
        return result;

    }

    // 덤프: 데이터 출력
    public void dump() {

        if (num <= 0) {
            System.out.println("큐가 비어있습니다.");
        } else {
            for (int i = 0; i < num; i++){
                int index = ( i + front ) % max;
                System.out.print(que[index] + " ");
            }

            System.out.println();
        }

    }

}
