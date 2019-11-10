package com.liang.thread;

/**
 * 守护线程：是为用户线程服务的，jvm停止不用等待守护进程的
 * 默认都是用户线程，jvm等待用户线程执行完毕才会停止
 * daemon线程守护线程，jvm不用等待完成
 */

public class DeamonTest {

    public static void main(String[] args) {
        God god = new God();
        My me = new My();

        Thread t = new Thread(god);
        t.setDaemon(true);
        t.start();
        new Thread(me).start();
    }
}


class My extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 365 * 100; i++) {
            System.out.println("happy life....");
        }
        System.out.println("0 0 0  0 .....");
    }
}

class God extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 365 * 1000000; i++) {
            System.out.println("blessing  me....");
        }
        System.out.println("0 0 0  0 .....");
    }
}