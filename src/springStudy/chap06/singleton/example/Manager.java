package springStudy.chap06.singleton.example;

public class Manager {

    static Manager manager = null;

    private Manager(){ }

    public synchronized static Manager getManager(){
        if (manager == null) manager = new Manager();
        return manager;
    }

}

