package com.liang.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip: 路由，rip, rspf
 *
 * InetAddress
 *      getLocalHost
 *      getByName  ip|域名得到 ip
 *      getHostName 获取主机名
 */

public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();

        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());


        InetAddress addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostName());
        System.out.println(addr.getHostAddress());
    }
}
