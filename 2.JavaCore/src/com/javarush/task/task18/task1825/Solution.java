package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new TreeSet<>();
        String fileName;
        while (!(fileName = bufferedReader.readLine()).equals("end")) {
            set.add(fileName);
        }
        String filePath = set.iterator().next();
        String fileOutput = filePath.substring(0, filePath.lastIndexOf('.'));
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOutput, true)) {
            for (String s : set) {
                try (FileInputStream fileInputStream = new FileInputStream(s)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    fileOutputStream.write(buffer);
/*                    byte[] buffer = new byte[102400];
                    while (fileInputStream.available() > 0) {
                        fileInputStream.read(buffer);
                        fileOutputStream.write(buffer);
                    }*/
                }
            }
        }
    }
}
