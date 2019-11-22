package com.jackson.udp;


import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 1. 使用DataGramScoket指定端口，创建接收端
 * 2. 准备容器 封装成packet
 * 3. 阻塞 接收包裹recieve
 * 4. 分析数据
 * 5. 释放资源
 */
public class UdpTypeServer {
    public static void main(String[] args) throws IOException {
        System.out.println("启动");
        DatagramSocket server = new DatagramSocket(9999);

        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);

        server.receive(packet);


        byte[] datas = packet.getData();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));

        System.out.println(new String(datas));

        server.close();
    }
}
