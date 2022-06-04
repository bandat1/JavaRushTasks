package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        String third = reader.readLine();

        try (FileInputStream inputStream1 = new FileInputStream(second);
             FileInputStream inputStream2 = new FileInputStream(third);
             FileOutputStream outputStream = new FileOutputStream(first))
        {
            while (inputStream1.available() > 0) {
                outputStream.write(inputStream1.read());
            }
            while (inputStream2.available() > 0) {
                outputStream.write(inputStream2.read());
            }

        }
    }
}
