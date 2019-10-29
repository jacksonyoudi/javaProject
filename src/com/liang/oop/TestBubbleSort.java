package com.liang.oop;

import java.util.Arrays;

public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = {1, 34, 5, 7, 19, 59, 56, 88, 44, 33};

        int tmp = 0;
        int length = values.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (values[i] < values[j]) {
                    tmp = values[i];
                    values[i] = values[j];
                    values[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(values));
    }
}
