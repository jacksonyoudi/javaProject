package com.jackson.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 是引用serversocket
 */

public class Server04 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server04 server01 = new Server04();
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
            new Request(client);
            send(client);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(Socket client) {
        try {
            OutputStream outputStream = client.getOutputStream();
            String html = new String("<h>a</h>");
            outputStream.write(html.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
