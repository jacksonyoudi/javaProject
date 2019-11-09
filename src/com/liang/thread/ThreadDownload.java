package com.liang.thread;

public class ThreadDownload extends Thread {
    private String url;
    private String name;

    public ThreadDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        WebDonwload wd = new WebDonwload();
        wd.download(url, name);
    }

    public static void main(String[] args) {
        ThreadDownload td1 = new ThreadDownload("a", "1");
        ThreadDownload td2 = new ThreadDownload("b", "2");
        ThreadDownload td3 = new ThreadDownload("c", "3");
        ThreadDownload td4 = new ThreadDownload("d", "4");


        td1.start();
        td2.start();
        td3.start();
        td4.start();
    }

}
