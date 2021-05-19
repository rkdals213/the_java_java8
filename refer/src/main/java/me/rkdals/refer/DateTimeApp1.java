package me.rkdals.refer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeApp1 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); // Date인데 time을 가져옴...

        date.setTime(1032412412434L);  // 시간을 다시 설정함
        System.out.println(date);

        Calendar birthDate1 = new GregorianCalendar(1992, 9, 26); // type safe하지 않다
        Calendar birthDate2 = new GregorianCalendar(1992, Calendar.OCTOBER, 26);
        System.out.println(birthDate2.getTime()); // date가 나옴...
    }
}
