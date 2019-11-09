package com.liang.thread;

/**
 * 优先级 1-10
 * 1. NORM_PRIORITY 1
 * 2. MIN_PRIORITY  2
 * 3. MAX_PRIORITY  3
 * <p>
 * 表示概率， 不是代表绝对执行
 */

public class PriorityTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());

        MyPriority m = new MyPriority();
        Thread t1 = new Thread(m, "1");
        Thread t2 = new Thread(m, "2");
        Thread t3 = new Thread(m, "3");
        Thread t4 = new Thread(m, "4");
        Thread t5 = new Thread(m, "5");
        Thread t6 = new Thread(m, "6");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.NORM_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY * 4);
        t6.setPriority(Thread.MIN_PRIORITY * 9);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}

class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
