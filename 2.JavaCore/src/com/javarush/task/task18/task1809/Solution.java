package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        try (FileInputStream inputStream = new FileInputStream(path1);
            FileOutputStream outputStream = new FileOutputStream(path2)) {
            byte[] buffer = new byte[inputStream.available()];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
            }
            for (int j = buffer.length - 1; j >= 0; j--) {
                outputStream.write(buffer[j]);
            }
        }

    }
}
