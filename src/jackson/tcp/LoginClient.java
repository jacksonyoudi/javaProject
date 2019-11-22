package jackson.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 1. 建立链接 使用socket创建客户端 + 服务的地址和端口
 * 进行数据传输
 */

public class LoginClient {
    public static void main(String[] args) throws IOException {
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
        dos.close();
        client.close();
    }
}


class Channel implements Runnable {
    @Override
    public void run() {

    }
}