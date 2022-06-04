package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        PrintWriter printWriter = new PrintWriter(outputStream);
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            properties.setProperty(entry.getKey(), entry.getValue());
        }
        properties.store(outputStream, "");

    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry entry : properties.entrySet()) {
            runtimeStorage.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
