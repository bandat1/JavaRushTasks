package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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
                for (char ch : line.toCharArray()) {
                    if (ch == '.') {
                        writer.write('!');
                    } else {
                        writer.write(ch);
                    }
                }
                writer.write("\n");
            }
        }
    }
}
