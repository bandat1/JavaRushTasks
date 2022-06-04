package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try (FileInputStream file = new FileInputStream(path)) {
            byte[] bytes = new byte[256];
            while (file.available() > 0) {
                byte temp = (byte) file.read();
                bytes[temp] += 1;
            }
            int minValue = 256;
            for(int i = 0; i < bytes.length; i++) {
                int tmpData = (int) bytes[i];
                if (tmpData != 0) {
                    if (tmpData < minValue) minValue = tmpData;
                }
            }
            //в соответствии с частотой выводим байт
            for (int i = 0; i < bytes.length; i++){
                if (bytes[i] == minValue) {
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
        }
    }
}
