package com.liang.cooperation;

/**
 * 协作模型： 生产者消费者模型： 信号灯法
 */

public class CoTest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.tv.play("奇葩说");
            } else {
                this.tv.play("广告.....");
            }
        }
    }
}


class Watcher extends Thread {
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.tv.watch();
        }
    }
}

class Tv {
    String voice;

    // 信号灯
    // T
    boolean flag = true;

    public synchronized void play(String voice) {
        // 演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 表演时刻
        System.out.println("表演了:" + voice);
        this.notifyAll();
        this.flag = !this.flag;
        this.voice = voice;
    }

    public synchronized void watch() {
        System.out.println("听到了:" + voice);
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 表演时刻
        System.out.println("观看:" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }

}
