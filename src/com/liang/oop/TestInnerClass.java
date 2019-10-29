package com.liang.oop;

public class TestInnerClass {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}

class Outer {
    private int age = 10;

    public void testOuter() {

    }

    class Inner {
        public void show() {
            System.out.println("外部的成员变量 age" + Outer.this.age);
        }
    }
}
