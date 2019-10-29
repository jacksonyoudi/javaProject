package com.liang.collection;


/**
 * 自定义实现一个arraylist
 */
public class LArrayList {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    public LArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public LArrayList(int size) {
        elementData = new Object[size];
    }


    public void add(Object e) {
        this.elementData[size++] = e;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Object obj : this.elementData
        ) {
            if (obj == null) {
                sb.append("  ,");
            } else {
                sb.append(obj + ",");
            }

        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        LArrayList s1 = new LArrayList(20);
        s1.add("test");
        s1.add("heelo");
        s1.add("te");
        System.out.println(s1);
    }
}
