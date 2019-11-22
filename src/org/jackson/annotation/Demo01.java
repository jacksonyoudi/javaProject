package org.jackson.annotation;

import java.lang.reflect.Array;


public class Demo01 {

    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
    }

    @MyAnnotation(studentName = "he")
    private void test00() {
        System.out.println("hello");
    }

}
