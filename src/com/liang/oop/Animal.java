package com.liang.oop;

public abstract class Animal {
    //  第一：没有实现， 子类必须实现， 不能new
    //  规范，模板

    public abstract void say();

    public void run() {
        System.out.println("run");
    }
}

class Dog extends Animal {
    @Override
    public void say() {
        System.out.println("ok");
    }
}
