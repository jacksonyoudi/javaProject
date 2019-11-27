package com.jackson.gof.singleton;

/**
 * 静态内部类实现方式
 */

public class SingletonDemo04 {
    private static class SingletonClassInstance {
        private static final SingletonDemo04 instance = new SingletonDemo04();
    }

    public static SingletonDemo04 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonDemo04() {

    }
}
