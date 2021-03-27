package caseStudy.common;

import java.awt.*;

public abstract class MyEvent {

    public String title;

    public MyEvent(String title) {
        this.title = title;
    }

    // 이는 isRelevant 이벤트를 개념적으로 포괄하는 것임
    // 고로 내부에 구현할 내용이 없는 추상적인 내용임.
    public abstract boolean isRelevant(MyDate myDate);

}
