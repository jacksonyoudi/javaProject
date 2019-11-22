package com.liang.thread;

/**
 * 可重入锁
 */

public class LockTest {
    public void test() {
        synchronized (this) {
            while (true) {
                synchronized (this) {
                    System.out.println("reentrantLock");
                }
            }
        }
    }

    public static void main(String[] args) {
        new LockTest().test();
    }
}
