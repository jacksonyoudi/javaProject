package com.liang.common;

public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN.ordinal() );
    }
}


enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}