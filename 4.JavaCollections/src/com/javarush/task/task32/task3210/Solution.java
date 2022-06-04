package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        /**
         * 1) fileName - путь к файлу;
         * 2) number - число, позиция в файле;
         * 3) text - текст.
         Считать текст с файла начиная с позиции number, длиной такой же как и длина переданного текста в третьем параметре.
         Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
         */
        final String fileName = args[0];
        final String number = args[1];
        String text = args[2];

        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw");) {
            raf.seek(Long.parseLong(number));
            byte[] buffer = new byte[text.length()];
            raf.read(buffer, 0, buffer.length);
            raf.seek(raf.length());
            if (new String(buffer).equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
