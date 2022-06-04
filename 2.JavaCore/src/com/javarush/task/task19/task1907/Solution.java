package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
/*
        String email = "word:";
        System.out.println(email.matches("(word).*"));
*/

        int countOfWords = 0;
        String string;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            string = bufferedReader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(string))) {
            while (reader.ready()) {
                String line = reader.readLine();
                for (String word : line.split("\\W")) {
                    if (word.equals("world")) countOfWords++;
                }
            }
        }
        System.out.println(countOfWords);
    }
}
