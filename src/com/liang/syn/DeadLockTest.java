package com.liang.syn;

/**
 * 死锁： 过多的同步等待可能会造成互相不释放资源
 * 从而互相等待，一般发生于同步中持有多个对象的锁
 *
 * 不要在同一个代码块中同时持有多个对象的锁
 */

public class DeadLockTest {
    public static void main(String[] args) {
        Markup g1 = new Markup(0, "one");
        Markup g2 = new Markup(1, "two");
        g1.start();
        g2.start();
    }
}


class Lipstic {

}

class Mirror {

}


class Markup extends Thread {
    static Lipstic stick = new Lipstic();
    static Mirror mirror = new Mirror();


    int choice;
    String name;

    @Override
    public void run() {
        markup();
    }

    public Markup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    public void markup() {
        if (choice == 0) {
            synchronized (stick) {
                System.out.println(name + "获得口红");
                // 1s后，获得镜子
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 不要锁后锁
//                synchronized (mirror) {
//                    System.out.println(name + "照镜子，涂口红");
//                }
            }

            synchronized (mirror) {
                System.out.println(name + "照镜子，涂口红");
            }
        } else {
            synchronized (mirror) {
                System.out.println(name + "获得镜子");
                // 1s后，拿口红
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//
//                synchronized (stick) {
//                    System.out.println(name + "照镜子，涂口红");
//                }
            }
            synchronized (stick) {
                System.out.println(name + "照镜子，涂口红");
            }


        }
    }


}