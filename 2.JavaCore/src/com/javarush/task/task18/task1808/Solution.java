package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String path1 = buff.readLine();
        String path2 = buff.readLine();
        String path3 = buff.readLine();

        try (FileInputStream inputStream = new FileInputStream(path1);
            FileOutputStream outputStream1 = new FileOutputStream(path2);
            FileOutputStream outputStream2 = new FileOutputStream(path3)) {
            if (inputStream.available() % 2 == 0) {
                byte[] buffer = new byte[inputStream.available() / 2];
                inputStream.read(buffer);
                outputStream1.write(buffer);
                inputStream.read(buffer);
                outputStream2.write(buffer);
            } else {
                byte[] longBuffer = new byte[(inputStream.available() / 2) + 1];
                byte[] shortBuffer = new byte[inputStream.available() / 2];
                inputStream.read(longBuffer);
                outputStream1.write(longBuffer);
                inputStream.read(shortBuffer);
                outputStream2.write(shortBuffer);
            }
        }
    }
}
