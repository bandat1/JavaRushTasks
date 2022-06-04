package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Enumeration;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long length = raf.length();
        long num = Long.parseLong(args[1]);
        num = num > length ? length : num;
        raf.seek(num);
        raf.write(args[2].getBytes());

    }
}
