package com.liang.thread;

import java.util.concurrent.*;

/**
 * 实现call方法
 */

public class CDownloader implements Callable<Boolean> {
    private String url;
    private String name;


    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println(url + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader td1 = new CDownloader("a", "1");
        CDownloader td2 = new CDownloader("b", "2");
        CDownloader td3 = new CDownloader("c", "3");
        CDownloader td4 = new CDownloader("d", "4");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(4);

        // 提交执行
        Future<Boolean> rs1 = ser.submit(td1);
        Future<Boolean> rs2 = ser.submit(td2);
        Future<Boolean> rs3 = ser.submit(td3);
        Future<Boolean> rs4 = ser.submit(td4);

        // 获取结果
        Boolean r1 = rs1.get();
        Boolean r2 = rs2.get();
        Boolean r3 = rs3.get();
        Boolean r4 = rs4.get();

        System.out.println(rs1);
        // 关闭服务
        ser.shutdown();

    }

}
