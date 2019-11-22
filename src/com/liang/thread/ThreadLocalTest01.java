package com.liang.thread;

/**
 * threadlocal： 每个线程自身的存储本地，局部区域
 * get、set，intialValue
 */

public class ThreadLocalTest01 {
    //    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//        @Override
//        protected Integer initialValue() {
//            return 200;
//        }
//    };

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 200);


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
    }
}
