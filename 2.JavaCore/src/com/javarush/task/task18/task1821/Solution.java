package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String mode = args[0];
       // String mode = "C:\\Users\\denis\\IdeaProjects\\Test\\file4.txt";
        Map<Integer, Integer> map = new TreeMap<>();
        if (mode.length() == 0) return;
        try (FileReader fileReader = new FileReader(mode)) {
            while (fileReader.ready()) {
                int i = fileReader.read();
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }
        for (Integer i : map.keySet()) {
            int a = (int) i;
            char ch = (char) a;
            System.out.println(ch + " " + map.get(i));
        }
    }
}
