package springStudy.chap06.singleton;

public class Singleton {

    static Singleton singleton;

    private Singleton() { }

    public static Singleton getInstance() {

        if (singleton == null)
            singleton = new Singleton();

        return singleton;

    }

}



