package com.liang.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * url， http, html
 * 1. protocal
 * 2。 domain
 * 3. port
 * 4. source
 */

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573753840535&di=534ce5cbcd3269da444f4de136bfbe7d&imgtype=0&src=http%3A%2F%2Fupload.semidata.info%2Fnew.eefocus.com%2Farticle%2Fimage%2F2018%2F01%2F11%2F5a56a906ef267.jpg");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
    }
}
