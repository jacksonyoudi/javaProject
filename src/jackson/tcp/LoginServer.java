package jackson.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. 指定端口 serversocket
 * 2. 阻塞监听 等待连接
 * 3. 操作，输入输出
 * 4. 释放资源
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept(); // 阻塞的
        System.out.println("一个客户端链接过来了");


        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        while (true) {
            String data = dis.readUTF();
            System.out.println(data);
            if (data.equals("bye")) {
                break;
            }
            dos.writeUTF("ok");
            dos.flush();

        }
        dis.close();
        client.close();
    }
}
