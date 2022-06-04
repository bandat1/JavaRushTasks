package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Временное сохранение файла
*/

/**
 * Напиши код, который будет считывать с клавиатуры ссылку на файл в интернете, скачивать его и сохранять во временный файл.
 * Используй методы createTempFile(null, null) и write(Path, byte[]) класса Files, а также метод openStream() класса URL.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //напишите тут ваш код
        URL url = new URL(line); // из строки получаем урл
        byte[] bytes = url.openStream().readAllBytes(); //открываем поток чтения по урлу и считываем все байты
        Path path = Files.createTempFile(null, null); //создаем временный файл
        Files.write(path, bytes); //записываем считанные байты во временный файл

    }
}