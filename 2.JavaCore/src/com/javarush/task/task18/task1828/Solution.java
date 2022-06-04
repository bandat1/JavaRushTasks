package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

/**
 * 1. Программа должна считать имя файла для операций CRUD с консоли.
 * 2. При запуске программы без параметров список товаров должен остаться неизменным.
 * 3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
 * 4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
 */
public class Solution {
    public static void main(String[] args) throws IOException  {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String mode = args[0];
        String id = args[1];
        if (mode.length() == 0) return;
        ArrayList<String> buffer = new ArrayList<>(0);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String lineId = line.substring(0, 8).trim();
                if (lineId.equals(id)) {
                    switch (mode) {
                        case "-u":
                            StringBuilder id2 = new StringBuilder("");
                            if (id.length() > 8) {
                                id2.append(id.substring(0, 8));
                            }
                            String productName = args[2];
                            StringBuilder productName2 = new StringBuilder("");
                            if (productName.length() > 30) {
                                productName2.append(productName.substring(0, 30));
                            }
                            String price = args[3];
                            StringBuilder price2 = new StringBuilder("");
                            if (price.length() > 8) {
                                price2.append(price.substring(0, 8));
                            }
                            String quantity = args[4];
                            StringBuilder quantity2 = new StringBuilder("");
                            if (quantity.length() > 4) {
                                quantity2.append(quantity.substring(0, 4));
                            }
//                            if (productName.length() > 30) productName = productName.substring(0, 31);
                            String newLine = String.format("%-8d%-30s%-8s%-4s", id, productName2, price2, quantity2);
                            buffer.add(newLine);
                            break;
                        case "-d":
                            continue;
                    }
                } else {
                    buffer.add(line);
                }
            }
        }
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (String line : buffer) {
                fileWriter.write(line + "\n");
            }
        }
    }
}
