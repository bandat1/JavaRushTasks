package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws  IOException {
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
                String[] words = bufferedReader.readLine().split(" ");
                for (String word : words) {
                    boolean isDigit = true;
                    StringBuilder stringBuilder = new StringBuilder(word);
                    for (int i = 0; i < stringBuilder.length(); i++) {
                        if (!Character.isDigit(stringBuilder.charAt(i))) isDigit = false;
                    }
                    if (isDigit) writer.write(word + " ");
                    isDigit = true;
                }
            }
        }
    }
}
