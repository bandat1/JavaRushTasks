package com.javarush.task.pro.task15.task1508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Читаем из консоли
*/

/**
 * Программа считывает из консоли строку и выводит ее на экран, чередуя регистр символов: первый символ —
 * в нижнем регистре, второй — в верхнем, третий — в нижнем, и т.д.
 * Не меняя функциональности программы, перепиши код с использованием BufferedReader для чтения из консоли.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 1) {
                System.out.print(String.valueOf(chars[i]).toUpperCase());
            } else {
                System.out.print(String.valueOf(chars[i]).toLowerCase());
                }
            }
        reader.close();
    }
}

