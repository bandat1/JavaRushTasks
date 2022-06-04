package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine())))
        {
            int count = 0;
            String l;
            while ((l = reader.readLine()) != null) {
                String[] line = l.split(" ");
                for (String s : line) {
                    if (words.contains(s)) count++;
                }
                if (count == 2) {
                    StringBuilder newLine = new StringBuilder("");
                    for (String s : line) {
                        newLine.append(s + " ");
                    }
                    System.out.print(newLine.toString().trim() + "\n");
                }
                count = 0;
            }
        }
    }
}
