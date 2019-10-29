package com.liang.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String str = df.format(new Date(40000000));
        System.out.println(str);
    }
}
