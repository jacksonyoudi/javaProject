package com.liang.thread;

/**
 * 静态代理, 代理模式
 * 接口
 * 1. 真实角色
 * 2. 代理角色
 */

public class StaticProxy {

    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();

        // new Thread(new Runnable)
    }
}


interface Marry {
    void happyMarry();
}

// 真实角色

class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("marry happy!!!");
    }
}

// 代理角色
class WeddingCompany implements Marry {
    // 真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready() {
        System.out.println("ready .....");
    }

    private void after() {
        System.out.println("after .....");
    }

}