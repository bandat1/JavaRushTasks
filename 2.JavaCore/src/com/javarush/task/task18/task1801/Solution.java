package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
        Scanner scanner = new Scanner(input);
        String path = scanner.nextLine();
        try (FileInputStream file = new FileInputStream(path)) {
            int max = 0;
            while (file.available() > 0) {
                int b = file.read();
                max = b > max ? b : max;
            }
            System.out.println(max);
        }
        scanner.close();
    }
}
