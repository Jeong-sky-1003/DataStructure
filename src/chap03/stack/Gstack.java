package chap03.stack;

import java.util.EmptyStackException;

public class Gstack<E> {

    private int max;
    private int ptr;
    private E[] stk;

    // 빈 stack 예외처리
    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
        }
    }

    // 오버플로우 예외처리
    public static class OverFlowStackException extends RuntimeException {
        public OverFlowStackException() {
        }
    }

    // 생성자를 통한 초기화
    public Gstack(int capacity) {
        this.ptr = 0;
        this.max = capacity;

        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }

    }

    // 푸쉬
    public E push(Object e) throws OverFlowStackException {
        if (ptr >= max) throw new OverFlowStackException();
        return stk[ptr++] = (E) e;
    }

    // 팝
    public E pop() throws EmptyStackException {
        if (ptr <= 0) throw new EmptyStackException();
        return stk[--ptr];
    }

    // 피크 : 꼭대기 값 확인
    public E peek() throws EmptyStackException {
        return stk[ptr - 1];
    }

    // 덤프 : 바닥부터 꼭대기 값 출력
    public void dump() throws EmptyStackException {
        if (ptr <= 0) throw new EmptyStackException();
        for (E e : stk) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // 검색 : 꼭대기부터 바닥까지 검색함
    public int indexOf(Object e) throws EmptyStackException {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == e) return i;
        }
        return -1;
    }

    // 전체 삭제
    public void clear() {
        ptr = 0;
    }

    // 데이터 수 확인
    public int size() {
        return ptr;
    }

    // empty 여부
    public boolean isEmpty() {
        return (ptr <= 0);
    }

    // full 여부
    public boolean isFull() {
        return (ptr == max);
    }

    // 용량 확인
    public int capacity() {
        return max;
    }

}
