package com.liang.thread;
/**
 * 1. 继承thread,重写run
 */

public class StartThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        Thread st = new StartThread();
        st.start(); // 开启一个进程
        for (int i = 0; i < 20; i++) {
            System.out.println("一边coding");
        }
    }
}
