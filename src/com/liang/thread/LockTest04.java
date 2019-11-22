package com.liang.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest04 {
    ReentrantLock lock = new ReentrantLock();

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
        LockTest04 test = new LockTest04();
        test.a();
        test.doSomething();
    }
}
