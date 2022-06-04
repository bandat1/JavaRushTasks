package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/
//C:\Users\denis\IdeaProjects\Test\file1.txt

/**
 * Стандартный алгоритм для такого типа задач таков: Создаем массив счетчиков для каждого элемента, где индексом
 * будет сам элемент, а значением будет количество вхождений элемента. Такой алгоритм всегда эффективен,
 * если количество элементов, которые нужно посчитать невелико. Простые пример: байты, буквы алфавита.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try (FileInputStream file = new FileInputStream(path)) {
            byte[] bytes = new byte[256];
            while (file.available() > 0) {
                byte temp = (byte) file.read();
                bytes[temp] += 1;
            }
            int maxValue = bytes[0];
            for(int i = 0;i < bytes.length; i++){
                int tmpData = (int) bytes[i];
                if (tmpData > maxValue) maxValue = tmpData;
            }

            //в соответствии с частотой выводим байт
            for (int i = 0; i < bytes.length; i++){
                if (bytes[i] == maxValue) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
