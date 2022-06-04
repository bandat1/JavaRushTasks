package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.2, "tt");
        labels.put(1.3, "ttj");
        labels.put(1.4, "tth");
        labels.put(1.5, "ttg");
        labels.put(1.6, "ttf");
    }


    public static void main(String[] args) {
        System.out.println(labels);
    }
}
