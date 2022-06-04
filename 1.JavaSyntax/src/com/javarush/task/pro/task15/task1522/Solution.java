package com.javarush.task.pro.task15.task1522;

import java.io.*;
import java.net.URL;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.com.ua/api/1.0/rest/projects");
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }
        reader.close();

        /* альтернаятивное решение
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);
         */
    }
}