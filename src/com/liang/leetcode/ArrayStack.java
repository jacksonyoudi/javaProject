package com.liang.leetcode;

// 基于数组实现的顺序栈
public class ArrayStack<T> {
    private Object[] items; // 数组
    private int count;   // 栈中元素个数
    private int n;     //栈的大小


    // 初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n) {
        this.n = n;
        this.items = new Object[n];
        this.count = 0;
    }


    // 入栈
    public boolean push(T item) {
        // 判断空间容量， ()
        if (count == n) {
            return false;
        }

        // 先放到count下， count++
        items[count++] = item;
        return true;
    }

    // 出栈
    public T pop() {
        if (count == 0) {
            return null;
        }

        Object tmp = items[count - 1];
        --count;
        return (T) tmp;
    }


}
