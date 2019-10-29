package com.liang.collection;

import java.util.HashMap;
import java.util.Map;


public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "hello");
        m1.put(2, "world");
        m1.put(3, "three");

        System.out.println(m1);
        System.out.println(m1.size());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("three"));

        // 不能重复， 重复使用equal
        System.out.println(m1.get(2));
    }
}
