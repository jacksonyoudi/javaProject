package com.liang.com.liang.io;

public class TestDecorate01 {
    public TestDecorate01() {
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.say();

        Amplifier am = new Amplifier(p);
        am.say();
    }
}


interface Say {
    void say();
}

class Person implements Say {
    private int voice = 10;

    @Override
    public void say() {
        System.out.println("人的声音为:" + this.getVoice());
    }

    public Person() {
    }

    public int getVoice() {
        return voice;
    }
}


class Amplifier implements Say {
    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为:" + p.getVoice() * 100);
        System.out.println("噪音");
    }
}

