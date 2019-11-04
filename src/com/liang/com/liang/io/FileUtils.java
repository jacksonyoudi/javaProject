package com.liang.com.liang.io;

import java.io.*;

public class FileUtils {
    public static void main(String[] args) {
        // 文件到文件
        try {
            InputStream is = new FileInputStream("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/a.txt");
            OutputStream os = new FileOutputStream("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/a-copy.txt");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream is, OutputStream os) {
        byte[] car = new byte[3];
        int tmp = -1;
        while (true) {
            try {
                if (!((tmp = is.read(car)) != -1)) break;
                os.write(car, 0, car.length);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(InputStream is, OutputStream os) {


    }

    public static void close(Closeable... ios) {
        for (Closeable io:ios) {
            try {
                if (io != null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
