package com.liang.thread;


public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("....");
        });
        Thread.State state = t.getState();
        System.out.println(state);

        t.start();
        state = t.getState();
        System.out.println(state);

        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();
            System.out.println(state);
            if (state.equals(Thread.State.TERMINATED)) {
                System.out.println("close");
                break;
            }

        }
    }
}
