package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        //напишите тут ваш код
        URLConnection connection = url.openConnection();

        // получили поток для отправки данных
        connection.setDoOutput(true); //разрешаем отправку данных
        OutputStream output = connection.getOutputStream();
        PrintStream stream = new PrintStream(output);
        stream.println("Строка");
        stream.println("Строка2");
        stream.close();
        // получили поток для чтения данных
        InputStream input = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }
        reader.close();
    }
}

