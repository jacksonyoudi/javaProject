package com.liang.com.liang.io;

import java.io.*;

public class TestOut {
    public static void main(String[] args) {
        // 1.创建源
        File src = new File("/Users/youdi/Project/javaProject/Video/src/com/liang/com/liang/io/b.txt");
        // 2. 选择源
        OutputStream os = null;

        try {
            os = new FileOutputStream(src);
            // 操作
            String str = "so easy";

            // 字符串到字节数组是编码
            byte[] datas = str.getBytes();
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
