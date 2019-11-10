package com.liang.thread;


public class InfoTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());

        MyInfo info = new MyInfo("战斗机");
        Thread thread = new Thread(info);
        thread.setName("公鸡");
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isAlive());

    }
}


class MyInfo implements Runnable {
    private String name;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public MyInfo(String name) {
        this.name = name;
    }
}