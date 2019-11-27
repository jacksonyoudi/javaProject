package com.jackson.gof.factory.abs;

public interface Engine {
    void run();

    void start();
}


class LuxuryEngine implements Engine {
    @Override
    public void run() {
        System.out.println("gao run");
    }

    @Override
    public void start() {
        System.out.println("start.....");

    }
}


class LowEngine implements Engine {
    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void start() {
        System.out.println("start.....");

    }
}