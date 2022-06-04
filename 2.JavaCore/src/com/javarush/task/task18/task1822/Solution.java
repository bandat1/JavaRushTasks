package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String mode = args[0];
        if (mode.length() == 0) return;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine())))
        {
            String id = null;
            while (reader.ready()) {
                String line = reader.readLine();
                StringBuilder builder = new StringBuilder(line);
                for (int i = 0; i < builder.length(); i++) {
                    if (builder.charAt(i) == ' ') {
                        id = builder.substring(0, i);
                        break;
                    }
                }
                if (id.equals(mode)) {
                    System.out.println(line);
                }
            }
        }
    }
}
