package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> map = new TreeMap<>();
            while (reader.ready()) {
                String[] lines = reader.readLine().split(" ");
                if (map.containsKey(lines[0])) {
                    map.put(lines[0], map.get(lines[0]) + Double.valueOf(lines[1]));
                } else {
                    map.put(lines[0], Double.valueOf(lines[1]));
                }
            }
            double max = 0;
            for (String key : map.keySet()) {
                if (map.get(key) > max) max = map.get(key);
            }
            for (String key : map.keySet()) {
                if (map.get(key) == max) System.out.println(key);
            }
        }
    }
}
