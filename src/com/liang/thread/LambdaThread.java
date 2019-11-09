package com.liang.thread;

/**
 * lambda表达式 简化线程(用一次)使用
 * 使用内部类
 */

public class LambdaThread {
    // 静态内部类 只用使用才会编译， 不使用不编译
    static class Test implements Runnable {
        public Test() {
            System.out.println("内部类");
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("hello");
            }
        }
    }


    public static void main(String[] args) {
        // 只是使用一次
        new Thread(new Test()).start();

        // 方法内部类
        class Test2 implements Runnable {
            public Test2() {
                System.out.println("内部类");
            }

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("hello");
                }
            }
        }

        new Thread(new Test2()).start();


        // 匿名内部类 必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("hello");
                }
            }
        }).start();


        // jdk8简化,简化简单的线程类
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("hello");
            }
        }).start();
    }
}
