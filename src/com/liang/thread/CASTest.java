package com.liang.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas：比较并交换 乐观锁
 */
public class CASTest {
    // 库存
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Integer left = stock.decrementAndGet();
                if (left < 1) {
                    System.out.println("空 ");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "抢了一件商品");
                System.out.println("还剩--> " + left);
            }).start();
        }
    }

}
