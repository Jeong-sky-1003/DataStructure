package chap03.generic;

public class GenericClassTester {

    static class GenericClass<T> {

        private T xyz;

        GenericClass(T t) {
            this.xyz = t;
        }

        T getXyz() {
            return this.xyz;
        }

    }

}
