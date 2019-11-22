package com.liang.thread;

/**
 * 用于保证数据的同步性，也是可见性 电脑的性能越来越高
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(
                () -> {
                    while (num == 0) {

                    }
                }
        ).start();

        Thread.sleep(100);
        num = 1;
    }
}
