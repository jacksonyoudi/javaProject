package com.liang.thread;

/**
 * join合并线程，阻塞其他线程 插队
 */

public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("lammb-->" + i);
            }
        });

        t.start();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("rang....");
                t.join();
            }
        }


        MyYield01 my = new MyYield01();
        new Thread(my, "a").start();
        new Thread(my, "b").start();
    }
}
