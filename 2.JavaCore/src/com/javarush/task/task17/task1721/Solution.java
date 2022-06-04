package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

/**
 * Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
 * 1. Считать с консоли 2 имени файла.
 * 2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
 * Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
 * Не забудь закрыть потоки.
 */
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        try (FileReader fileReader1 = new FileReader(first);
             FileReader fileReader2 = new FileReader(second);
             BufferedReader buff1 = new BufferedReader(fileReader1);
             BufferedReader buff2 = new BufferedReader(fileReader2)) {
            String buff1Line = buff1.readLine();
            while (buff1Line != null) {
                allLines.add(buff1Line);
                buff1Line = buff1.readLine();
            }
            String buff2Line = buff2.readLine();
            while (buff2Line != null) {
                forRemoveLines.add(buff2Line);
                buff2Line = buff2.readLine();
            }
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        reader.close();
    }

    /**
     *  * В методе joinData:
     *  * 3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
     *  которые есть в forRemoveLines.
     *  * 4. Если условие из п.3 не выполнено, то:
     *  * 4.1. очистить allLines от данных
     *  * 4.2. выбросить исключение CorruptedDataException
     */
    public void joinData() throws CorruptedDataException {
        int countOfLines = 0;
        for (String str : forRemoveLines) {
            for (String s : allLines) {
                if (str.equals(s)) {
                    countOfLines++;
                    break;
                }
            }
        }
        if (countOfLines != forRemoveLines.size()) {
            allLines.clear();
            throw new CorruptedDataException();
        } else {
            allLines.removeAll(forRemoveLines);
        }
    }
}
