package com.liang.com.liang.io;

import java.io.*;

public class TestIO5 {
    public static void main(String[] args) {
        File src = new File("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/a.txt");

        Reader r = null;

        try {
            r = new FileReader(src);
            char[] flush = new char[3];
            int len = -1;
            while ((len=r.read(flush))!=-1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
