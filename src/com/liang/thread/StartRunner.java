package com.liang.thread;

/**
 * 优先使用接口，避免单继承的局限，共享资源
 */

public class StartRunner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("coding");
        }
    }

    public static void main(String[] args) {
//        // 创建实现类对象
//        StartRunner st = new StartRunner();
//
//        // 创建代理类对象
//        Thread t = new Thread(st);
//
//        // 启动
//        t.start();
        new Thread(new StartRunner()).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("听歌");
        }
    }
}


