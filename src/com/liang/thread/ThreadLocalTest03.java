package com.liang.thread;

/**
 *
 * 注意上下文
 * 1. 构造器: 哪里调用，就属于哪里， 找线程体
 */

public class ThreadLocalTest03 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    // 进行ThreadLocal的共享
    private static ThreadLocal<Integer> threadLocal1 = new InheritableThreadLocal<>();



    public static void main(String[] args) {
        threadLocal.set(100);
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun()).start();
        }

    }


    public static class MyRun implements Runnable {

        public MyRun() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "--->" + left);
        }

        @Override
        public void run() {
            Integer left = threadLocal.get();

            System.out.println(Thread.currentThread().getName() + "得到了--->" + left);
            threadLocal.set(left - 1);
            left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "得到了--->" + left);
        }
    }


}
