package com.liang.thread;

/**
 * 可重入锁：锁可以延续使用
 */

public class LockTest03 {
    ReLock lock = new ReLock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("a.......");
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
    }

    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println("dosomething");
        System.out.println(lock.getHoldCount());
        // ....
        lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        LockTest03 test = new LockTest03();
        test.a();
        test.doSomething();

        Thread.sleep(1000);
        System.out.println(test.lock.getHoldCount());
    }
}


class ReLock {
    // 是否占用
    private boolean isLocked = false;
    private Thread lockedBy = null; // 存储线程
    private int holdCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked && lockedBy != t) {
            wait();
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == lockedBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}
