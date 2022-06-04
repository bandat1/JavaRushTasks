package com.javarush.task.pro.task15.task1504;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        String str1 = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt";
        String str2 = "C:\\Users\\denis\\IdeaProjects\\Test\\file2.txt";
        Scanner scanner = new Scanner(System.in);
        Path path1 = Path.of(scanner.nextLine());
        InputStream inputStream = Files.newInputStream(path1);
        Path path2 = Path.of(scanner.nextLine()) ;
        OutputStream outputStream = Files.newOutputStream(path2);

        //byte[] buffer = new byte[65536]; // 64Kb
        int i = 0;
        while (inputStream.available() > 0)
        {
            if (inputStream.available() % 2 != 0) {
                if (inputStream.available() != 1) {
                    if (i == 0) {
                        i = inputStream.read();
                    } else {
                        outputStream.write(inputStream.read());
                        outputStream.write(i);
                        i = 0;
                    }
                } else {
                    outputStream.write(inputStream.read());
                }
            } else {
                if (i == 0) {
                    i = inputStream.read();
                } else {
                    outputStream.write(inputStream.read());
                    outputStream.write(i);
                    i = 0;
                }
            }
        }
        inputStream.close();
        outputStream.close();
    }
}

