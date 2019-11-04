package com.liang.com.liang.io;

public class TestContentEncode {
    public static void main(String[] args) {
        String msg = "aah中国";
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);

        String m = new String(datas, 0, datas.length);

        System.out.println(datas.toString());
    }
}
