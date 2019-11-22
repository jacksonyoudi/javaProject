package com.jackson.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1. 使用DataGramScoket指定端口，创建发送端
 * 2. 准备数据 一定要转成字节数组
 * 3. 封装成DatagramPacket包裹， 需要指定目的地
 * 4. 发送包裹send(DatagramPacket *p)
 * 5. 释放资源
 */

public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动端....");

        // 构建发送的udp 报文socket
        DatagramSocket client = new DatagramSocket(8888);

        // 数据

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();

            // 构建报文 packet 包含目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
            // 发送数据
            client.send(packet);
            if (data.equals("bye")) {
                break;
            }
        }
        client.close();

    }
}
