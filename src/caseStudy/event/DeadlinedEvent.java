package caseStudy.event;

import caseStudy.common.MyDate;
import caseStudy.common.MyEvent;

public class DeadlinedEvent extends MyEvent {

    private MyDate deadline;

    public MyDate getDeadline() {
        return deadline;
    }

    public DeadlinedEvent(String title, MyDate deadline) {
        super(title);
        this.deadline = deadline;
    }

    public String toString() {
        return title + ", " + deadline.toString();
    }

    @Override
    public boolean isRelevant(MyDate myDate) {
        return deadline.compareTo(myDate) >= 0;
    }

}
