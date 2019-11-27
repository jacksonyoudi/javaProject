package com.jackson.gof.singleton;


/**
 * 这个模式将同步内容放到if 内部，提高了执行的效率，不必每次获取对象时都进行同步，只有第一次才同步创建了以后就没有必要了。
 *
 * 问题：
 *      由于编译器优化的原因和JVM底层内部模型原因偶尔会出问题， 不建议使用。
 */

public class DoubleCheckLock {
    private static DoubleCheckLock instance = null;

    public static DoubleCheckLock getInstance() {
        if (instance == null) {
            DoubleCheckLock sc;
            synchronized (DoubleCheckLock.class) {
                sc = instance;
                if (sc == null) {
                    synchronized (DoubleCheckLock.class) {
                        sc = new DoubleCheckLock();
                    }
                }
            }
            sc = instance;
        }

        return instance;
    }

    private DoubleCheckLock() {

    }

}
