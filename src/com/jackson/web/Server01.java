package com.jackson.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 是引用serversocket
 */

public class Server01 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server01 server01 = new Server01();
        server01.start();
        server01.receive();
    }


    public void start() {
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }

    public void stop() {

    }

    public void receive() {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立的链接.....");

            // 获取协议
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024 * 1024];
            int len = is.read(datas);
            String requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
