package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        int ascii = (int) ',';
        int count = 0;
        try (FileInputStream file = new FileInputStream(path)) {
            while (file.available() > 0) {
                if (file.read() == ascii) count++;
            }
        }
        System.out.println(count);
    }
}
