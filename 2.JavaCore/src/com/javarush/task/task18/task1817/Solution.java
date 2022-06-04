package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String mode = args[0];
        double spaces = 0;
        double allMarks = 0;
        if (mode.length() != 0) {
            BufferedReader reader = new BufferedReader(new FileReader(mode));
            while (reader.ready()) {
                String line = reader.readLine();
                for (char c : line.toCharArray()) {
                    allMarks++;
                    if (c == ' ') spaces++;
                }
            }
            String result = String.format("%.2f", (spaces / allMarks) * 100);
            System.out.println(result);
            reader.close();
        }

    }
}
