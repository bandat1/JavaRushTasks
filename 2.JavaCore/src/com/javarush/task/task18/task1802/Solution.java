package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
        Scanner scanner = new Scanner(input);
        String path = scanner.nextLine();
        try (FileInputStream file = new FileInputStream(path)) {
            int min = Byte.MAX_VALUE;
            while (file.available() > 0) {
                int b = file.read();
                min = b < min ? b : min;
            }
            System.out.println(min);
        }
        scanner.close();
    }
}
