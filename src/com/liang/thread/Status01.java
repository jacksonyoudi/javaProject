package com.liang.thread;

/**
 * 终止线程
 * 1. 线程正常执行完毕
 * 2. 外部干涉 ---》 加入标记
 * 3.
 */

public class Status01 implements Runnable {
    private boolean flag = true;

    public Status01() {
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("name:" + i);
            i++;
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        Status01 tt = new Status01();
        new Thread(tt).start();

        for (int i = 0; i < 100; i++) {
            if (i == 88) {
                tt.setFlag(false);
            }
            System.out.println("for:" + i);
        }
    }
}
