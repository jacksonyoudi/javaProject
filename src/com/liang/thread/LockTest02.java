package com.liang.thread;

/**
 * 不可重入的锁：不可延续使用
 */

public class LockTest02 {
    Lock lock = new Lock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("a.......");
        doSomething();
        lock.unlock();
    }

    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println("dosomething");
        // ....
        lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        LockTest02 test = new LockTest02();
        test.a();
        test.doSomething();
    }
}

class Lock {
    // 是否占用
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        while (isLocked) {
            isLocked = false;
            notify();
        }
    }
}
