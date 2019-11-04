package com.liang.com.liang.io;

import java.io.File;

public class TestDirFile {
    public static void main(String[] args) {

    }


    public static void printName(File src, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.println("-");
        }
        System.out.println(src.getName());

        if (src == null || !src.exists()) {
            return;
        } else if (src.isDirectory()) {
            for (File s : src.listFiles()) {
                printName(s, deep + 1);
            }
        }
    }


    public static void count(File src) {
        if (src != null && src.exists()) {

        }
    }
}
