package com.jackson.gof.adapter;

/**
 * 被适配的对象
 */
public class Adaptee {
    public void request() {
        System.out.println("可以完成客户请求的需求的功能!");
    }
}
