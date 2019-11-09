package com.liang.thread;

public class LambdaTest01 {
    public static void main(String[] args) {
        Ilove l = (a, b) -> a;

        l.say(1, 2);


    }
}

interface Ilove {
    int say(int a, int a2);
}

class Love implements Ilove {
    @Override
    public int say(int a, int b) {
        return a;
    }
}
