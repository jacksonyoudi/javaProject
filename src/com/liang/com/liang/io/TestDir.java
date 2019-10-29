package com.liang.com.liang.io;

import java.io.File;

/**
 * mkdirs()
 * mkdir
 * <p>
 * list 列出下一级
 * listFiles() 列出下一级File()对象
 */
public class TestDir {
    public static void main(String[] args) {
        File dir = new File("./test");
        dir.mkdirs();
//        dir.mkdir();

        String[] subNames = dir.list();
        for (String sub : subNames
        ) {
            System.out.println(sub);

        }

        File[] files = dir.listFiles();
        for (File f : files
        ) {
            System.out.println(f.length());
        }


    }
}
