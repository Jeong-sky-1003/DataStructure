package caseStudy.event;

import caseStudy.common.MyDate;
import caseStudy.common.MyEvent;

public class OneDayEvent extends MyEvent {

    // extends로 상속 받을 때 자동으로 default 생성자가 생성됨
    // 이미 MyEvnet에 생성자를 하나 생성했는데, 이를 정해야 함

    private MyDate date;

    public OneDayEvent(String title, MyDate date){
        // super() method로 생성자에 접근
        super(title);
        this.date = date;
    }

    public String toString(){
        return title + ", " + date.toString();
    }

    @Override
    public boolean isRelevant(MyDate myDate) {
        return (this.date.compareTo(myDate) == 0);
    }

}
