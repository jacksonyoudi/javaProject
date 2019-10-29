package com.liang.collection;

import java.util.TreeMap;
import java.util.Map;

public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> m1 = new TreeMap<>();
        m1.put(20, "a1");
        m1.put(21, "a2");
        m1.put(23, "a3");
        m1.put(24, "a4");
        m1.put(25, "a5");

        for (Integer key : m1.keySet()
        ) {
            System.out.println(key + ":" + m1.get(key));
        }


        Map<Emp, Integer> m2 = new TreeMap<>();
        m2.put(new Emp(20, "h", 3000), 1);
        m2.put(new Emp(22, "h", 30), 2);
        m2.put(new Emp(23, "h", 400), 3);
        m2.put(new Emp(24, "h", 6000), 4);
        m2.put(new Emp(25, "h", 3), 5);
        m2.put(new Emp(27, "h", 200), 6);


        for (Emp key : m2.keySet()
        ) {
            System.out.println(key.salary + ":" + m2.get(key));
        }
    }
}


class Emp implements Comparable<Emp> {
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double slary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = slary;
    }

    @Override
    public int compareTo(Emp o) {
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary < o.salary) {
            return -1;
        } else {
            return 0;
        }
    }
}