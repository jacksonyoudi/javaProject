package com.liang.syn;

/**
 * 线程不安全，数据有重复(工作区)  负数情况（临界值）
 */

public class UnsafeTest implements Runnable {
    private int ticketsNums = 10;

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

        UnsafeTest web = new UnsafeTest();
        // 一份资源，多个代理
        new Thread(web, "1->").start();
        new Thread(web, "2->").start();
        new Thread(web, "3->").start();
        new Thread(web, "4->").start();
        new Thread(web, "5->").start();
        new Thread(web, "6->").start();
    }
}
