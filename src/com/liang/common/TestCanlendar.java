package com.liang.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCanlendar {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2999, 10, 9, 22, 10, 50);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);


        Date d4 = calendar.getTime();



    }
}
