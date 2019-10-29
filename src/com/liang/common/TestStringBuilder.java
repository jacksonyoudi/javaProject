package com.liang.common;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1111");

        // stringBuilder线程不安全， 效率高

        // StringBuffer线程安全，效率低。
        for (int i = 0; i < 26; i++) {
            char tmp = (char) ('a' + i);
            sb.append(tmp);
        }

        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        sb.insert(0, "h").reverse().insert(0, "y"); // 链式调用

        System.out.println(sb);
    }
}
