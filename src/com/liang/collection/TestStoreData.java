package com.liang.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class TestStoreData {
    public static void main(String[] args) {
        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 111);
        row1.put("name", "hello");
        row1.put("salary", 5000);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 112);
        row2.put("name", "hello");
        row2.put("salary", 5000);


        Map<String, Object> row3 = new HashMap<>();
        row2.put("id", 113);
        row2.put("name", "hello");
        row2.put("salary", 5001);


        List<Map<String, Object>> table1 = new ArrayList<>();
        table1.add(row1);
        table1.add(row2);
        table1.add(row3);


        for (Map<String, Object> row : table1) {
           Set<String> keyset = row.keySet();

            for (String key:keyset) {
                System.out.println(key + ":" + row.get(key));
            }

            System.out.println();
        }

    }
}
