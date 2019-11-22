package com.jackson.chat;

import java.io.Closeable;

public class ChatUtils {
    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            try {
                target.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
