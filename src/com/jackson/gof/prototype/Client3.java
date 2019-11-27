package com.jackson.gof.prototype;

import java.io.*;
import java.util.Date;

public class Client3 {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Sheep s1 = new Sheep("少利", new Date(12333344L));

        System.out.println(s1);
        Date d1 = s1.getBirthday();
//        Sheep s2 = (Sheep) s1.clone();
//


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);

        Sheep s2 = (Sheep) ois.readObject();

        System.out.println(s2.getBirthday());
        d1.setTime(1111L);
        System.out.println(s2.getBirthday());

    }
}
