package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder(l);
                stringBuilder.reverse();
                System.out.println(stringBuilder.toString());
                //System.out.println("\n");
            }
        }
    }
}
