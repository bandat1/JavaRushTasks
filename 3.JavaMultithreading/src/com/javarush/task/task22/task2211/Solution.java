package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(args[0]);
            FileOutputStream outputStream = new FileOutputStream(args[1])) {
            byte[] buffer = new byte[inputStream.available()];
            //byte[] buffer = new byte[1000];
            while (inputStream.available() > 0) {
                inputStream.read(buffer);
            }
                Charset utf8 = Charset.forName("UTF-8");
                Charset windows = Charset.forName("Windows-1251");
                String s = new String(buffer, windows);
                buffer = s.getBytes(utf8);
                outputStream.write(buffer);
        }
    }
}
