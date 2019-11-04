package com.liang.com.liang.io;

import java.io.*;

public class TestIO1 {
    public static void main(String[] args) {
        File src = new File("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/a.txt");
        FileInputStream is = null;
        try {
            is = new FileInputStream(src);
            int tmp;
            while ((tmp = is.read()) != -1) {
                System.out.println((char) tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
