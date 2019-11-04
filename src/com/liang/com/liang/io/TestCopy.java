package com.liang.com.liang.io;

import java.io.*;

public class TestCopy {
    public static void main(String[] args) {
        File src = new File("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/a.txt");
        File dst = new File("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/c.txt");

        InputStream is = null;
        OutputStream os = null;

        // 读
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dst);
            byte[] car = new byte[3];
            int tmp = -1;
            while ((tmp = is.read(car)) != -1) {
                os.write(car, 0, car.length);
                os.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
