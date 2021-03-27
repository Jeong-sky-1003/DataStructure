package chap03.stack;

public class IntStack {

    private int ptr;
    private int max;
    private int[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public class OverFlowIntStackException extends RuntimeException {
        public OverFlowIntStackException() {
        }
    }

    public IntStack(int capacity) {

        ptr = 0;
        max = capacity;

        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }

    }

    // 스택의 모든 데이터 출력: 바닥 -> 꼭대기
    public void dump() {
        if (ptr <= 0) System.out.println("데이터가 존재하지 않습니다.");
        else {
            for (int i = 0; i <= ptr - 1; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }

    // 가득 찼는지 확인
    public boolean isFull() {
        return ptr >= max;
    }

    // 비어있는지 확인
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 데이터 수 확인
    public int size() {
        return ptr;
    }

    // 스택 용량 확인
    public int capacity() {
        return max;
    }

    // 스택 모든 요소 삭제
    public void clear() {
        ptr = 0;
    }

    /*
        특정 값 검색하기
        꼭대기 -> 바닥
     */
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == x) return i;
        }
        return -1;
    }

    // 꼭대기 데이터를 옅보는 메서드
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) throw new EmptyIntStackException();
        return stk[--ptr];
    }

    public int push(int x) throws OverFlowIntStackException {

        if (ptr >= max) {
            throw new OverFlowIntStackException();
        }

        return stk[ptr++] = x;

    }

}
