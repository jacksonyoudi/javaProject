package com.jackson.udp;

import com.liang.oop.Str;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * 1. 使用DataGramScoket指定端口，创建接收端
 * 2. 准备容器 封装成packet
 * 3. 阻塞 接收包裹recieve
 * 4. 分析数据
 * 5. 释放资源
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("启动");
        DatagramSocket server = new DatagramSocket(9999);

        while (true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);

            server.receive(packet);

            byte[] datas = packet.getData();
            String data = new String(datas, 0, datas.length);
            System.out.println(data);
            if (data.equals("bye")) {
                break;
            }
        }

        server.close();
    }
}
