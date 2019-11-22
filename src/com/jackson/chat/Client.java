package com.jackson.chat;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("client");
        Socket client = new Socket("localhost", 8888);

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(client.getInputStream());
        while (true) {
            String data = console.readLine();
            dos.writeUTF(data);
            dos.flush();
            if (data.equals("bye")) {
                break;
            }
            String out = dis.readUTF();
            System.out.println("output" + out);

        }
        dis.close();
        dos.close();
        client.close();
    }

}
