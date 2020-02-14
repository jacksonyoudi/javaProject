package com.jackson.gof.adapter;

public class Client2 {
    public void test1(Target t) {
        t.handleReq();
    }

    public static void main(String[] args) {
        Client2 c = new Client2();
        Adaptee a = new Adaptee();
        Target t = new Adapter2(a);
        c.test1(t);
    }
}
