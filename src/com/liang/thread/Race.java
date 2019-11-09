package com.liang.thread;

/**
 * 模拟龟兔赛跑
 */

public class Race implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            if (Thread.currentThread().getName().equals("rabbit") && i % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "--->" + i);
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner===>" + winner);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Race r = new Race();
        new Thread(r, "tortoise").start();
        new Thread(r, "rabbit").start();
    }

}
