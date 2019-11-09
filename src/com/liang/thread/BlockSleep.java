package com.liang.thread;

/**
 * 使用sleep模拟网络延时
 */

public class BlockSleep {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Web12 web = new Web12();
        // 一份资源，多个代理
        new Thread(web, "1->").start();
        new Thread(web, "2->").start();
        new Thread(web, "3->").start();
    }
}


class Web12 implements Runnable {
    private int ticketsNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketsNums <= 0) {
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ticketsNums--);
        }
    }


}