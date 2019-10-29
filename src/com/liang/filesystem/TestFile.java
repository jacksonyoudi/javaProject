package com.liang.filesystem;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {
//        File file = new File("./TestFile.java");
//        System.out.println(file);


        File f1 = new File("hello.txt");
        f1.createNewFile();
        
    }
}
