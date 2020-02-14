package com.jackson.gof.adapter;


/**
 * 适配器
 * 类适配的方式
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void handleReq() {
        super.request();
    }
}
