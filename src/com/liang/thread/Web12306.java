package com.liang.thread;

/**
 * 共享资源，并发(线程安全)
 */

public class Web12306 implements Runnable {
    private int ticketsNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketsNums <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + ticketsNums--);
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Web12306 web = new Web12306();
        // 一份资源，多个代理
        new Thread(web, "1->").start();
        new Thread(web, "2->").start();
        new Thread(web, "3->").start();
        new Thread(web, "4->").start();
        new Thread(web, "5->").start();
        new Thread(web, "6->").start();
    }
}
