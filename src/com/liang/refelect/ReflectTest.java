package com.liang.refelect;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 对象.class
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        // 类
        clz = Class.forName("com.liang.refelect.Iphone");
    }
}


class Iphone {
    public Iphone() {
    }
}