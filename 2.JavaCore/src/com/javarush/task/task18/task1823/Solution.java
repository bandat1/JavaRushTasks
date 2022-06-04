package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = reader.readLine();
            if (str.equals("exit")) break;
            ReadThread readThread= new ReadThread(str);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
                int[] array = new int[256];
                while (inputStream.available() > 0) {
                    int i = inputStream.read();
                    array[i]++;
                }
                int max = 0;
                int b = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > max) {
                        max = array[i];
                        b = i;
                    }
                }
                resultMap.put(fileName, b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
