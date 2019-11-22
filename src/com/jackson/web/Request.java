package com.jackson.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Request {
    private String requestInfo;
    private String method;
    private String uri;


    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request(InputStream is) {
        byte[] datas = new byte[1024 * 1024];
        int len = 0;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 分解字符串
        parseRequestInfo();
    }


    private void parseRequestInfo() {
        System.out.println(requestInfo);
        this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
        this.uri = this.requestInfo.substring(this.requestInfo.indexOf("/"), this.requestInfo.indexOf("HTTP/"));
        System.out.println(this.method);
        System.out.println(this.uri);

        int queryIdx = this.uri.indexOf("?");
        if (queryIdx > 0) {
            String[] urlArray = this.uri.split("\\?");
            this.uri = urlArray[0];
            this.uri = urlArray[1];
        }

    }
}
