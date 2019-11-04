package com.liang.com.liang.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestIO7 {
    public static void main(String[] args) {
        byte[] dest = null;

        ByteArrayOutputStream baos = null;
        baos = new ByteArrayOutputStream();

        String msg = "show me the code";
        byte[] datas = msg.getBytes();

        baos.write(datas, 0, datas.length);
        try {
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(baos.toString());


    }
}
