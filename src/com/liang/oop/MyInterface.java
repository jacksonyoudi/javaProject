package com.liang.oop;


// 规范
public interface MyInterface {
    int max = 400; //  publish static final

    void test1(); // public abstract
}


class MyClass implements MyInterface {
    @Override
    public void test1() {
        System.out.println("hello");
        System.out.println(max);
    }
}
