package springStudy.chap06.singleton.example;

public abstract class Interview {

    protected String interview = "no interview";

    public void setInterview(String interview){
        this.interview = interview;
    }

    public String getInterview(){
        return this.interview;
    }

}


