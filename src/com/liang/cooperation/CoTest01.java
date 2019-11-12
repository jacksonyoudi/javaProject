package com.liang.cooperation;

/**
 * 协作模型:生产者实现方式一：管程法
 */

public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Productor(container).start();
        new Consumer(container).start();
        new Consumer(container).start();
    }
}


// 生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        // 生产

        for (int i = 0; i < 100; i++) {
            System.out.println("producer--->" + i + "馒头");

            synchronized (container) {
                container.push(new Steamedbun(i));
            }
        }
    }
}


class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (container) {
                System.out.println("消费--->" + container.pop().id + "馒头");
            }

        }
    }
}


// 缓存区
class SynContainer {
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;

    //生产
    public void push(Steamedbun bun) {
        // 容器有空间就可以生产
        if (count >= buns.length) {
            try {
                this.wait(); // 线程阻塞， 消费者通知生产解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buns[count] = bun;
        this.notifyAll(); // 通知消费
        count++;
    }

    // 消费
    public  Steamedbun pop() {
        // 何时消费
        if (count == 0) {
            try {
                this.wait(); // 线程阻塞，生产者通知消费接触，会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        count--;
        Steamedbun bun = buns[count];
        this.notifyAll(); // 通知生产
        return bun;
    }
}


class Steamedbun {
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}