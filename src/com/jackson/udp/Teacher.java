package com.jackson.udp;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(9999)).start();
        new Thread(new TalkSend(6666, "localhost", 8888)).start();
    }
}
