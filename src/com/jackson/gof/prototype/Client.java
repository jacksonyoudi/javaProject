package com.jackson.gof.prototype;


import java.util.Date;

/**
 * 浅克隆
 */

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep s1 = new Sheep("少利", new Date(12333344L));

        System.out.println(s1);

        Sheep s2 = (Sheep) s1.clone();
        System.out.println(s2.getBirthday());
        s2.setBirthday(new Date(111L));
        System.out.println(s1.getBirthday());


    }
}
