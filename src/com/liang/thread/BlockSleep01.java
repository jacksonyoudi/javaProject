package com.liang.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockSleep01 {

    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endTime.getTime();
        while (true) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime() + 1000);
            if (endTime.getTime() - end > 10000) {
                break;
            }
        }
    }

    public static void test() {
        int num = 10;
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(num--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
