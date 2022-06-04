package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }

/*        Map<Integer, String> list = new HashMap<>();
        list.put(3, "aaa");
        list.put(5, "bbb");
        String i = list.get(2);
        System.out.println(i);*/
    }
}