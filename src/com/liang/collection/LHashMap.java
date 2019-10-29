package com.liang.collection;

import java.util.HashMap;

public class LHashMap<K, V> {
    HashNode<K, V>[] table; // 位桶数组
    int size;

    public LHashMap() {
        table = new HashNode[16];
    }


    public void put(K key, V value) {
        // 定义了一个新节点
        HashNode<K, V> node = new HashNode<>();
        node.hash = myHash(key.hashCode(), table.length);
        node.key = key;
        node.value = value;
        node.next = null;

        HashNode<K, V> tmp = table[node.hash];
        HashNode<K, V> last = null;

        if (tmp == null) {
            table[node.hash] = node;
        } else {
            // 数组数据不为空，更新或追加
            while (tmp != null) {
                if (node.key.equals(tmp.key)) {
                    //覆盖
                    tmp.value = node.value;
                    return;
                } else {
                    last = tmp;
                    tmp = tmp.next;
                }
            }

            last.next = node;
            size++;
        }
    }


    public void show() {
        int length = table.length;
        for (int i = 0; i < length; i++) {
            HashNode head = table[i];
            if (head != null) {
                System.out.println("table: " + i);
                HashNode tmp = head;
                while (tmp != null) {
                    System.out.println("key:" + tmp.key + " value:" + tmp.value);
                    tmp = tmp.next;
                }
            }
        }
    }


    public V get(K key) {
        int hash = key.hashCode() & (table.length - 1);
        HashNode<K, V> node = table[hash];

        if (node != null) {
            while (node != null) {
                if (key.equals(node.key)) {
                    return node.value;
                }
                node = node.next;
            }
        }


        return null;
    }


    private int myHash(int v, int length) {
        // v % length
        return v & (length - 1);
    }


    public static void main(String[] args) {
        LHashMap<Integer, String> lhm = new LHashMap<>();
        lhm.put(0, "hello");
        lhm.put(16, "hello world");
        lhm.put(0, "world");
        lhm.put(3, "xiix");

//        lhm.show();
        System.out.println(lhm.get(16));
    }
}



