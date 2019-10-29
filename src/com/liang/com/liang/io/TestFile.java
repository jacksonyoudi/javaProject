package com.liang.com.liang.io;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        String path = "/Users/youdi/Project/javaProject/Video/hello.txt";

        File src = new File(path);
        System.out.println(src.length());


        src.getName();
        src.getAbsolutePath();
        src.getParent();
        src.exists();
        src.isFile();
        src.isDirectory();
        src.length();

        try {
            src.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        src.delete();
    }
}
