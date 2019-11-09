package com.liang.thread;

public class BlockedJoin02 {
    public static void main(String[] args) {
        System.out.println("爸爸让儿子去买烟");
        new Thread(new Father()).start();
    }
}


class Father extends Thread {
    @Override
    public void run() {
        System.out.println("想抽烟，让儿子去买烟");
        System.out.println("买中华");

        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join(); // father被阻塞
            System.out.println("老板接过烟，把零钱给了儿子");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Thread {
    @Override
    public void run() {
        System.out.println("接过老板的钱出去了.....");
        System.out.println("路边有一个游戏厅，玩了10s");

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

