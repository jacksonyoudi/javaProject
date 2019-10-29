package com.liang.collection;

import java.util.*;

public class TestInterator {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorSet();
        testIteratorMap();
    }


    public static void testIteratorList() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        // 获取迭代器
        Iterator<String> itet = list.iterator();

        //
        for (; itet.hasNext(); ) {
            String tmp = itet.next();
            System.out.println(tmp);
        }
    }


    public static void testIteratorMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "stat");
        map.put(3, "test");


        Set<Map.Entry<Integer, String>> ss = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iter = ss.iterator();
        for (; iter.hasNext(); ) {
            Map.Entry<Integer, String> tmp = iter.next();
            System.out.println("key:" + tmp.getKey() + "value:" + tmp.getValue());
        }

        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();

        for (; iterator.hasNext(); ) {
            Integer key = iterator.next();
            System.out.println("key:" + key + " value:" + map.get(key));
        }
    }


    public static void testIteratorSet() {
        Set<String> s = new HashSet<>();
        s.add("hello");
        s.add("world");
        s.add("bb");
        s.add("cc");
        s.add("dd");
        // 获取迭代器
        Iterator<String> itet = s.iterator();

        for (; itet.hasNext(); ) {
            String tmp = itet.next();
            System.out.println(tmp);
        }
    }

}
