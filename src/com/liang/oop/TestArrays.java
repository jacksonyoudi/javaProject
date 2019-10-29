package com.liang.oop;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        int[] a = {100, 20, 50, 40};
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        // 基本类型会被包装成对象
        Object[] a3 = {1001, "hello", 12};
        System.out.println(Arrays.toString(a3));

    }
}
