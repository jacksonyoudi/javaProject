package com.liang.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 端口：
 *     区分软件
 *     2个字节 0-65535
 *     同一协议不能冲突
 *     定义端口越来越大
 *     Inte
 *
 * 1. 构造器
 *      new
 */

public class PortTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getAddress());
    }

}
