package com.liang.collection;


/**
 * 自定义实现一个arraylist
 */
public class LArrayList1<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    public LArrayList1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public LArrayList1(int size) {
        if (size < 0) {
            throw new RuntimeException("size不能为负数");
        }
        elementData = new Object[size];
    }


    public void add(E e) {
        //什么时候扩容
        if (size == elementData.length) {
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        this.elementData[size++] = e;
    }


    public E get(int index) {
        // 判断是否合法
        checkRange(index);
        return (E) elementData[index];
    }


    public void set(E element, int index) {
        // 检查是否存在
        checkRange(index);
        elementData[index] = element;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合法");
        }
    }


    public void remove(int index) {
        int num = elementData.length - index - 1;
        if (num > 0) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, num);
        }
        elementData[--size] = null;

    }


    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(this.get(i))) {
                remove(i);
                break;
            }
        }
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

    public int size() {
        return size;
    }


    public boolean isEmpty() {

        if (elementData.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LArrayList1<String> s1 = new LArrayList1(20);
        for (int i = 0; i < 40; i++) {
            s1.add("liang_" + i);
        }
        s1.set("hello", 10);
        s1.remove("liang_13");
        System.out.println(s1);
        System.out.println(s1.get(13));
    }
}

