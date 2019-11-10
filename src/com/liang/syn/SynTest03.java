package com.liang.syn;

import java.util.ArrayList;
import java.util.List;


/**
 * synchronized只能锁一个，一个资源或对象
 */


public class SynTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        // 注意， 需要等待执行完
        System.out.println(list.size());
    }
}
