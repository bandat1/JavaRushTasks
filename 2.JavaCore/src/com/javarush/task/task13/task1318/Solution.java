package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        //String path = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt";

        StringBuilder builder = new StringBuilder("Hello!");
//        StringBuilder newBuilder = new StringBuilder(builder);

        for (int i = builder.length() - 1; i >= 0; i--) {
            int first = builder.length() - i - 1;
            int last = i;
            if (first < last) {
                char c = builder.charAt(last);
                builder.setCharAt(last, builder.charAt(first));
                builder.setCharAt(first, c);

            } else {
                break;
            }
            //newBuilder.setCharAt(builder.length() - i - 1, builder.charAt(i));
        }
        System.out.println(builder);

        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);

        Scanner scanner = new Scanner(fileInputStream);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        System.out.print(builder.toString());

        scanner.close();
        reader.close();
*/

    }
}