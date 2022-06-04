package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String arg0 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String arg1 = new BufferedReader(new InputStreamReader(System.in)).readLine();*/
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            StringBuilder stringBuilder = new StringBuilder("");
            while (reader.ready()) {
                String[] words = reader.readLine().split(" |\n");
                for (String word : words) {
                    if (word.length() > 6) stringBuilder.append(word + ",");
                }
            }
            fileWriter.write(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
        }
    }
}

