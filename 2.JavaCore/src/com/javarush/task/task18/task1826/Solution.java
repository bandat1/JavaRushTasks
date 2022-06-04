package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

/**
 * 1. Считывать с консоли ничего не нужно.
 * 2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
 * 3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
 * 4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
 * 5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
 * 6. Созданные для файлов потоки должны быть закрыты.
 * -e fileName fileOutputName
 * -d fileName fileOutputName
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        switch (args[0]) {
            case "-e":
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read() + 2);
                }
                break;
            case "-d":
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read() - 2);
                }
                break;
        }
        inputStream.close();
        outputStream.close();
    }
}
