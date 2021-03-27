package caseStudy.common;

public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }

    // 두 가지를 받아 비교하기 위함
    // 자기자신 VS other
    public int compareTo(MyDate other) {

        if (year < other.year || year == other.year && month < other.month
                || year == other.year && month == other.month && day < other.day) {

            // 비교한 날짜가 더 큰 경우
            return -1;

        } else if (year > other.year || year == other.year && month > other.month
                || year == other.year && month == other.month && day > other.day) {

            // 비교한 날짜가 더 작은 경우
            return 1;
        } else {
            // 비교한 날짜가 동일한 경우
            return 0;
        }

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

}
