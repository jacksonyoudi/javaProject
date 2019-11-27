package com.jackson.gof.factory.abs;

public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryCar();
        Engine e = factory.createEngine();
        e.run();
        e.start();
    }
}
