package com.liang.others;

/**
 * 指令重排:
 *
 */

public class HappenBefore {
    private static int a = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(
                () -> {
                    a = 1;
                    flag = true;
                }
        );


        Thread t2 = new Thread(
                () -> {
                    if (flag) {
                        a *= 1;
                    }

                    if (a == 0) {
                        System.out.println("happen before a->" + a);
                    }
                }
        );

        t2.start();
        t.start();


        t.join();
        t2.join();
    }
}
