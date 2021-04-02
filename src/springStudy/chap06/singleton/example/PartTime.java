package springStudy.chap06.singleton.example;

public class PartTime extends Interview implements Interviewable{

    private String name;

    public PartTime(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "PartTime{" + "name='" + name + '\'' + ", interview='" + super.getInterview() + "'}";
    }

}

