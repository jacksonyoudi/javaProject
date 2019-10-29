package com.liang.collection;

import java.util.ArrayList;
import java.util.List;

public class TestStoreData2 {
    public static void main(String[] args) {
        User user1 = new User(1, "hello", 333, "2019");
        User user2 = new User(2, "world", 334, "1988");
        User user3 = new User(3, "xixi", 335, "777");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for (User u : list) {
            System.out.println(u.getId() + u.getName() + u.getSalay() + u.getDate());
        }
    }
}

class User {
    private int id;
    private String name;
    private double salay;
    private String date;


    //  一个完整的java bean，要有set和get方法，以及无惨的构造器
    public User() {

    }

    public User(int id, String name, double salay, String date) {
        this.id = id;
        this.name = name;
        this.salay = salay;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalay() {
        return salay;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
