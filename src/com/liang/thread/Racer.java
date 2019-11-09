package com.liang.thread;

import java.util.concurrent.*;

/**
 * 模拟龟兔赛跑
 */

public class Racer implements Callable<Integer> {
    private static String winner;


    @Override
    public Integer call() throws Exception {
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
                return i;
            }
        }
        return 0;
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


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Racer r = new Racer();

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);

        // 提交执行
        Future<Integer> rs1 = ser.submit(r);
        Future<Integer> rs2 = ser.submit(r);

        // 获取结果
        Integer r1 = rs1.get();
        Integer r2 = rs2.get();

        System.out.println(r1 + "--->" + r2);
        // 关闭服务
        ser.shutdown();


    }

}
