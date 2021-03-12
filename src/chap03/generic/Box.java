package chap03.generic;

// Generics 예시
public class Box<T> {

    // Generics : parameterized 된 클래스
    /*
        T : 가상적인 데이터 타입
        T로 선언함으로 할당되는 데이터 타입을 정수, 변수로 고정하지 않음
     */
    private T t;    // t type의 어떤 변수

    // 매개변수로 받은 t를 해당 클래스의 t에 할당
    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

}


