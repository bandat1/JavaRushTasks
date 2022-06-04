package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Прайсы
*/

/**
 * 1. Программа должна считать имя файла для операций CRUD с консоли.
 * 2. В классе Solution не должны быть использованы статические переменные.
 * 3. При запуске программы без параметров список товаров должен остаться неизменным.
 * 4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая
 * строка с товаром.
 * 5. Товар должен иметь следующий id, после максимального, найденного в файле.
 * 6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
 * 7. Созданные для файлов потоки должны быть закрыты.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (args.length == 0) return;
        if (args.length == 4 && args[0].equalsIgnoreCase("-c")) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            //int[] wordsLength = {8, 30, 8, 2};
            int max = 0;
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                int value = Integer.parseInt((line.substring(0, 8)).trim());
                if (value > max) max = value;
            }
            bufferedReader.close();
            FileWriter fileWriter = new FileWriter(fileName, true);
            //%-30 (выравнивание по левому краю и если строка меньше 30 символов добавляются недостающие пробелы)
            //.30 (максимальное количество символов, если строка больше то она обрезается)
            //s (строка)
/*            String id = String.format("%-8.8s", max + 1);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format("%-8.8s", args[2]);
            String quantity = String.format("%-2.2s", args[3]);
            String newLine = String.format("\n" + id + productName + price + quantity);*/
            String newLine = String.format("%-8d%-30.30s%-8.8s%-4.4s", max + 1, args[1], args[2],args[3]);
            fileWriter.write("\n");
            fileWriter.write(newLine);
            fileWriter.close();
        }
    }
}
