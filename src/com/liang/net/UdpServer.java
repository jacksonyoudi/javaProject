package com.liang.net;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 1. 使用DatagramSocket指定端口 创建接收端
 * 2. 准备容器，用于接收数据， 封装成DatagramPacket包裹
 * 3. 封装成Datagrampacket 包裹，需要指定目的地
 * 4. 发送包裹
 * 5. 释放资源
 */

public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中....");
        DatagramSocket client = new DatagramSocket(8888);

        String data = "youdi";
        byte[] datas = data.getBytes();

        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
        client.send(packet);

        client.close();
    }
}
