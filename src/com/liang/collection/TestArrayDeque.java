package com.liang.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestArrayDeque {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("test");
        deque.add("a");
        deque.add("b");

        System.out.println(deque.pop());
        deque.add("d");

        System.out.println(deque.pop());
    }

}
