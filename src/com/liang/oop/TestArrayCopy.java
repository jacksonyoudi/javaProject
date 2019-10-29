package com.liang.oop;

public class TestArrayCopy {
    public static void main(String[] args) {

        String[] s1 = {"a", "b", "c", "d"};
        String[] s2 = new String[20];
        System.arraycopy(s1, 2, s2, 6, 1);

        System.out.println(s2.toString());
    }


    // 删除数组中指定索引位置的元素，并将原数组返回
    public static String[] delete(String[] s, int index) {
        System.arraycopy(s, index, s, index - 1, s.length - index);
        s[s.length - 1] = null;
        return s;
    }
}
