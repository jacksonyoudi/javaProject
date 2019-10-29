package com.liang.common;

public class TestWrappedClass {
    public static void main(String[] args) {
        // 基本类型转成包装类
        Integer i = new Integer(10);
        Integer i2 = Integer.valueOf(20);

        // 包装对象转成基本类型
        int j = i.intValue();

        Integer f = Integer.parseInt("9999");
    }
}
