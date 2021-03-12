package chap03.section5;

import chap03.Chapter03;

import javax.jws.Oneway;
import java.util.Arrays;

public class MyArrayList <E> implements Chapter03 {

    private static final int INIT_CAPACITY = 10;
    private E[] theData;
    private int size;       // 데이터 할당된 크기
    private int capacity;   // 배열의 현재 크기

    // 생성자에서는 type parameter를 쓸 필요가 없음
    public MyArrayList(){
        /*
            Generic의 배열 생성
            theData = new E[INIT_CAPACITY];
            위 코드는 에러가 발생함
            자바 규칙 상 new 명령어 다음에 존재하지 않은 type parameter 는 선언될 수 없음
            고로 Object type 배열로 생성한 뒤 명시적 변환 진행
         */
        theData = (E[]) new Object[INIT_CAPACITY];
        size = 0;
        capacity = INIT_CAPACITY;
    }

    // reallocate :
    private void reallocate(){

        // 방법 두 가지가 존재함
        // 1번: 더 큰 배열을 생성한 뒤
        // 원래 존재하는 데이터를 새로운 배열에 할당함
        // E []tmp = (E[]) new Object[capacity * 2];

        // 2번: capacity를 두 배로 늘린 뒤 자바에서 제공되는 라이브러리로 배열 생성
        capacity *= 2;
        // theData 배열을 capacity만큼 늘리고 기존 배열인 theData 카피 진행
        theData = Arrays.copyOf(theData, capacity);

    }

    // remove : index 해당 값 삭제
    public E remove(int index){

        // index 값 예외처리
        if (index < 0 || size <= index)
            throw new ArrayIndexOutOfBoundsException(index);

        // 삭제할 Index 번호의 값 리턴
        E returnValue = theData[index];
        // 값 삭제를 위한 반복문
        for (int i = size - 1; i >= index; i--){
            theData[i-1] = theData[i];
        }
        size--;
        
        return returnValue;

    }

    // index 위치 값 변경
    public E set(int index, E newEntity){

        // index가 0보다 작거나 size보다 큰 경우 예외처리
        if (index < 0 || size <= index)
            throw new ArrayIndexOutOfBoundsException(index);

        // index에 문제가 없을 경우 해당 index에 값을 할당하고, 기존 값 return
        E oldEntity = theData[index];
        theData[index] = newEntity;
        return oldEntity;

    }

    // get: index번에 위치한 값 가져오기
    public E get(int index){
        if (index < 0 || size <= index)
            throw new ArrayIndexOutOfBoundsException(index);
        return theData[index];
    }

    // indexOf: 데이터를 받아 데이터가 존재하면 index 번호 아니면 -1
    public int indexOf(E anEntry){

        for (int i=0; i < size; i++){

            // 하지만 동일성을 판단하는 것은 Primitive type에 한정됨
            // 고로 reference type은 equals로 비교되는데, 아래와 같이 코딩할 경우 에러 발생함
            // if (theData[i] == anEntry) return i;

            if (theData[i].equals(anEntry)) return i;

        }
        return -1;
    }

    // size 갯수 리턴
    public int size(){
        return size;
    }

    // add method : 맨 뒤에 데이터 추가
    public void add(E anEntity){
        theData[size++] = anEntity;
    }

    // add method : 지정 인덱스에 데이터 추가 기능
    public void add(int index, E anEntity){

        // 새로운 데이터가 삽입되는데 앞에 빈 공간이 생기는 경우 방지
        // 즉, 유효하지 않은 인덱스가 발생할 경우 예외처리
        if ( index < 0 || size <= index){
            // 방법 1. return으로 일종의 오류 처리. 하지만 권장 X
            // return;
            // 방법 2. exception 처리
            throw new ArrayIndexOutOfBoundsException(index);
        }

        // 모든 데이터가 차있는 경우
        if (size >= capacity){
            reallocate();
        }

        // Index 번째 위치에 데이터를 추가하려면 index 번째 위치에 index 번호부터 뒤에 있는 데이터 shift 진행
        // Index 부터 size - 1번까지 데이터를 이동시킴
        for (int i = size-1; i >= index; i--){
            // 뒤에서부터 검토하기에 임시 변수가 필요 없음
            theData[i + 1] = theData[i];
        }
        theData[index] = anEntity;
        size++;

    }

    @Override
    public void start() {

        MyArrayList<String> test = new MyArrayList<>();

        try {
            test.add(1, "hello");
        } catch ( ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

    }

}
