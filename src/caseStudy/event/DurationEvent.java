package caseStudy.event;

import caseStudy.common.MyDate;
import caseStudy.common.MyEvent;

public class DurationEvent extends MyEvent {

    private MyDate begin;
    private MyDate end;

    public MyDate getBegin() {
        return begin;
    }

    public MyDate getEnd() {
        return end;
    }

    public DurationEvent(String title, MyDate begin, MyDate end) {
        super(title);
        this.begin = begin;
        this.end = end;
    }

    public String toString() {
        return title + ", " + begin.toString() + " ~ " + end.toString();
    }

    @Override
    public boolean isRelevant(MyDate myDate) {
        return (begin.compareTo(myDate) <= 0
                && end.compareTo(myDate) >= 0);
    }

}
