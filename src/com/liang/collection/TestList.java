package com.liang.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());
        c.add("hello");
        c.add("test");

        System.out.println(c);
        Object[] a = c.toArray();
        c.remove("test");
        System.out.println(c);

        test02();
        test01();
    }


    public static void test02() {
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        l1.add("d");


        List<String> l2 = new ArrayList<>();
        l2.add("a");
        l2.add("b");
        l2.add("d");


        l1.retainAll(l2);
        System.out.println(l1);
    }


    public static void test01() {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list);
    }

}
