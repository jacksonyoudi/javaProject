package jackson.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 1. 建立链接 使用socket创建客户端 + 服务的地址和端口
 * 进行数据传输
 */

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8888);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
        dos.close();
        client.close();
    }
}
