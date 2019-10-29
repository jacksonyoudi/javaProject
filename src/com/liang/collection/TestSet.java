package com.liang.collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("hello");
        s.add("xixixi");

        System.out.println(s.toString());
    }
}
