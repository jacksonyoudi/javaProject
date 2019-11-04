package com.liang.com.liang.io;

import java.io.*;

public class TestIO {
    public static void main(String[] args) {
        File src = new File("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/a.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(src);
            int tmep;
            while ((tmep = inputStream.read()) != -1) {
                System.out.println((char) tmep);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
