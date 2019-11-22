package com.liang.thread;

/**
 * DCL 单例模式：套路， 在多线程环境下， 对外存在一个对象， 指令重排
 * 1. 构造私有化 --》 构造外部new 构造器
 * 2. 提供私有的静态属性， ---》 存储对象的地址
 * 3. 提供公共的静态方法  ---》 获取属性
 */
public class DoubleCheckLocking {
    private static volatile DoubleCheckLocking instance; // 懒汉式

    private DoubleCheckLocking() {
    }

    public static DoubleCheckLocking getInstance() {
        // 再次检测
        if (instance != null) {
            return instance;
        }

        // 锁定类
        synchronized (DoubleCheckLocking.class) {
            if (null == instance) {
                instance = new DoubleCheckLocking();
                // 1. 开辟空间  2. 初始化对象信息， 3. 返回对象地址给引用
            }
            return instance;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println(DoubleCheckLocking.getInstance());
        });

        t.start();

        Thread t1 = new Thread(() -> {
            System.out.println(DoubleCheckLocking.getInstance());
        });

        t1.start();
        t.join();
        t1.join();
    }


}
