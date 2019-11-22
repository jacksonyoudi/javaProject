package com.jackson.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1. 使用DataGramScoket指定端口，创建发送端
 * 2. 准备类型转成字节数组 一定要转成字节数组
 * 3. 封装成DatagramPacket包裹， 需要指定目的地
 * 4. 发送包裹send(DatagramPacket *p)
 * 5. 释放资源
 */

public class UdpTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动端....");

        // 构建发送的udp 报文socket
        DatagramSocket client = new DatagramSocket(8888);

        // 数据
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));


        dos.writeUTF("test");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();


        byte[] datas = baos.toByteArray();

        // 构建报文 packet 包含目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));

        // 发送数据
        client.send(packet);

        client.close();

    }
}
