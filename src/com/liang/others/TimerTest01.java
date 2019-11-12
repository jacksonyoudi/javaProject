package com.liang.others;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：借助Timer类
 */

public class TimerTest01 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTask task = new MyTask();
//        timer.schedule(task, 1000);
//        timer.schedule(task, 1000, 1000);
    }
}

class MyTask extends TimerTask {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello world");
        }
    }
}
