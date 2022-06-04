package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String string1;
        String string2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            string1 = reader.readLine();
            string2 = reader.readLine();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(string2)))
        {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String newLine = line.replaceAll("\\pP|\\n", "");
                writer.write(newLine);
            }
        }
    }
}
