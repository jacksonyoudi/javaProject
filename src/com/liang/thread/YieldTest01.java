package com.liang.thread;

/**
 * yield 直接进入就绪状态
 */

public class YieldTest01 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lammb");
            }
        }).start();


        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                Thread.yield();
                System.out.println("lirang");
            }
        }


        MyYield01 my = new MyYield01();
        new Thread(my, "a").start();
        new Thread(my, "b").start();
    }
}

class MyYield01 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----> start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "----> end");
    }
}
