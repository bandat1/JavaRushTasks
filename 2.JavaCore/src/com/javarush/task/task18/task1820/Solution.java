package com.javarush.task.task18.task1820;

import java.io.*;
import java.nio.channels.ScatteringByteChannel;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileInputName = reader.readLine();
        String fileOutputName = reader.readLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInputName));
             FileWriter fileWriter = new FileWriter(fileOutputName, true))
        {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                for (String s : line.split(" ")) {
                    fileWriter.write(String.valueOf(round(s)) + " ");
                }
            }
        }

    }

    static private int round(String s) {
        int value = 0;
        if (s.contains(".")) {
            String[] arr = s.split("\\.");
            int number = Integer.valueOf(arr[0]);
            int part = Integer.valueOf(arr[1]);
            if (part > 50) {
                value = number >= 0 ? number + 1 : number - 1;
            } else if (part == 50 || part == 5) {
                value = number >= 0 ? number + 1 : number;
            } else {
                value = number;
            }
        } else {
            value = Integer.parseInt(s);
        }
        return value;
    }
}
