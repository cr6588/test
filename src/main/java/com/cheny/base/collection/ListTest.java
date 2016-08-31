package com.cheny.base.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class ListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.get(0);
        System.out.println(5 >> 1);// 位运算5的二进制右移1位相当于除，LinkedList的get方法中如果小于size
                                   // >> 1则从前往后找，反之则从后往前找
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "cy");
        hashMap.put("name2", "cA");
        hashMap.put("name3", "cB");
        Iterator<Entry<String, Object>> mapIt = hashMap.entrySet().iterator();
        if (mapIt != null) {

            while (mapIt.hasNext()) {
                Entry<String, Object> type = mapIt.next();
                String key = type.getKey();
                String value = type.getValue().toString();
                System.out.println(key + ":" + value);
            }

            for (Entry<String, Object> entry : hashMap.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }

        }
    }


}
