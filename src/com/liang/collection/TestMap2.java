package com.liang.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(100, "gao", 100000);
        Employee e2 = new Employee(101, "hello", 1001);
        Employee e3 = new Employee(102, "world", 2000);


        Map<Integer, Employee> m1 = new HashMap<Integer, Employee>();

        m1.put(100, e1);
        m1.put(101, e2);
        m1.put(102, e3);


        System.out.println(e1.hashCode());
    }
}


class Employee {
    private int id;
    private String name;
    private double salay;

    public Employee(int id, String name, double salay) {
        super();
        this.id = id;
        this.name = name;
        this.salay = salay;
    }
}
