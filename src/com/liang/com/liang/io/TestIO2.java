package com.liang.com.liang.io;

import java.io.*;

public class TestIO2 {
    public static void main(String[] args) {
        // 创建源
        File src = new File("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/a.txt");

        // 选择流
        InputStream is = null;
        try {
            // 指定流
            is = new FileInputStream(src);
            // 操作读取
            byte[] car = new byte[3]; // 缓存容器
            int len = -1; // 接收长度
            while ((len = is.read(car)) != -1) {
                String str = new String(car, 0, len);
                System.out.println(str);
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
