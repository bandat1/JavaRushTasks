package com.javarush.task.pro.task15.task1507;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/
/*
Напиши программу, которая считывает из консоли имя текстового файла, далее читает строки из этого файла
(используй метод readAllLines(Path) класса Files) и выводит их на экран через одну, начиная с первой.
Requirements:
1. Программа должна считать из консоли путь к файлу.
2. Программа должна вывести в консоли содержимое файла согласно условию.
3. Для чтения строк из файла нужно использовать метод readAllLines(Path) класса Files.
4. Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        List<String> list = Files.readAllLines(Path.of(fileName));
        if (list.size() == 0) return;
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }
        if (list.size() % 2 == 0) {
            for (int i = 0; i < list.size() - 1; i += 2) {
                System.out.println(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i += 2) {
                System.out.println(list.get(i));
            }
        }
    }
}

