package com.liang.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestExp {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("./text");
            char c1 = (char)reader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("he");
        }
    }
}
