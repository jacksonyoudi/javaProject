package com.jackson.chat;

/**
 * 使用多线程
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Chat {
    private static Vector<Channel> channels = new Vector<>();

    public static void main(String[] args) throws IOException {
        System.out.println("start......");

        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("建立一个客户端");
            Channel channel = new Channel(client);
            channels.add(channel);
            new Thread(channel).start();
        }

    }

    static class Channel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;

        public Channel(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                this.close();
            }
            this.client = client;
        }

        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String h = client.getInetAddress().getCanonicalHostName();
            return h + ": \n" + msg;
        }

        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        private void sendOther(String msg) {
            for (Channel channe : channels
            ) {
                if (channe != this) {
                    channe.send(msg);
                }
            }
        }

        private void close() {
            ChatUtils.close(dis, dos, client);
        }


        @Override
        public void run() {
            while (true) {
                String msg = receive();
                System.out.println(msg);
                sendOther(msg);
            }
        }
    }


}
