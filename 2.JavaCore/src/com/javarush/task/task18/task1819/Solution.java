package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(first);
        byte[] buffer = new byte[inputStream1.available()];
        while (inputStream1.available() > 0) {
            inputStream1.read(buffer);
        }
        inputStream1.close();
        FileInputStream inputStream2 = new FileInputStream(second);
        FileOutputStream outputStream = new FileOutputStream(first);
        while (inputStream2.available() > 0) {
            outputStream.write(inputStream2.read());
        }
        outputStream.write(buffer);
        inputStream2.close();
        outputStream.close();
    }
}
