package com.jackson.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 */

public class TalkSend implements Runnable {
    private DatagramSocket client;
    private BufferedReader reader;
    private String toIp;
    private int toPort;

    public static void main(String[] args) {

    }

    public TalkSend(int port, String toIp, int toPort) {
        try {
            this.toIp = toIp;
            this.toPort = toPort;
            client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            String data;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();

                // 构建报文 packet 包含目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.toPort));
                // 发送数据
                client.send(packet);
                if (data.equals("bye")) {
                    break;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        client.close();
    }
}
