package com.liang.thread;

/**
 * DCL
 */
public class SingleTest {
    private volatile static SingleTest instance;

    public SingleTest() {

    }

    public static SingleTest getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (SingleTest.class) {
            if (instance == null) {
                instance = new SingleTest();
            }
            return instance;
        }
    }
}
