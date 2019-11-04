package com.liang.com.liang.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestIO6 {
    public static void main(String[] args) {
        byte[] src = "talk is chaep show me the code".getBytes();
        InputStream is = null;
        is = new ByteArrayInputStream(src);
        byte[] flush = new byte[5];
        int len = -1;
        while (true) {
            try {
                if (!((len = is.read(flush)) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = new String(flush, 0, len);
            System.out.println(str);
        }
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
