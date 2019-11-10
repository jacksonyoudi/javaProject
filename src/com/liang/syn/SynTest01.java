package com.liang.syn;

/**
 * 线程安全： 在并发时保证数据的正确性，效率尽可能高, 地址不能改变
 */

public class SynTest01 {
    public static void main(String[] args) {
        Web12306 web = new Web12306();
        // 一份资源，多个代理
        new Thread(web, "one->").start();
        new Thread(web, "two->").start();
        new Thread(web, "three->").start();
    }
}


class Web12306 implements Runnable {
    private int ticketsNums = 100;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test1();
        }
    }

    // 线程安全，同步 锁的是 ticketsNums 锁的是对象的资源
    private synchronized void test() {
        if (ticketsNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + ticketsNums--);
    }

    // 线程安全，同步 锁的是 ticketsNums 锁的是对象的资源
    private  void test1() {
        synchronized (this) {
            if (ticketsNums <= 0) {
                flag = false;
                return;
            }

            try {
                Thread.sleep(131);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ticketsNums--);
        }
    }


    // 线程安全，同步 锁的是 ticketsNums 锁的是对象的资源， 双重检测 double-check, 缩小锁定范围
    private synchronized void test3() {
        if (ticketsNums <= 0) { // 考虑没票的情况
            flag = false;
            return;
        }



        synchronized (this) {

            if (ticketsNums <= 0) { // 考虑最后一张票
                flag = false;
                return;
            }

            try {
                Thread.sleep(101);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ticketsNums--);
        }
    }
}
