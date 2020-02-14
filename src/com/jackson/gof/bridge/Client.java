package com.jackson.gof.bridge;

/**
 * 组合代替继承
 */

public class Client {
    public static void main(String[] args) {
        Computer c = new Laptop(new Lenovo());
        c.sale();
    }
}
