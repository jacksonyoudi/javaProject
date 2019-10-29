package com.liang.collection;

import java.util.HashMap;

public class LHashSet<K> {
    HashMap<K, Object> map;
    int size;
    private static final Object PRESENT = new Object();

    public LHashSet() {
        this.map = new HashMap<>();
    }

    public int size() {
        return size;
    }

    public void add(K obj) {
        map.put(obj, PRESENT);
    }

    public static void main(String[] args) {
        LHashSet<String> lhs = new LHashSet();
        lhs.add("hello");
        lhs.add("say");

        for (String s : lhs.map.keySet()
        ) {
            System.out.println(s);
        }
    }

}
