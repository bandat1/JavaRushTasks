package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String[] line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder("");
            while (reader.ready()) {
                stringBuilder.append(reader.readLine() + " ");
            }
            line = stringBuilder
                    .toString()
                    .trim()
                    .split(" ");
        }
        StringBuilder result = getLine(line);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder stringBuilder = new StringBuilder("");
        List<String> list = Arrays.asList(words);
        List<String> list1 = List.copyOf(list);
            //Collections.shuffle(list);
        int listSize = list.size();
        String iElement = "";
        int i = 0;
        int cicleNumber = 0;
        while (list.size() > 0) {
            if (cicleNumber <= listSize) {
                if (i == 0 && stringBuilder.toString().isEmpty()) {
                    stringBuilder.append(list.get(i));
                    iElement = list.get(i);
                    list.remove(i);
                    if (list.size() == 1) {
                        break;
                    } else {
                        continue;
                    }
                } else {
                    String jElement = list.get(i);
                    if (iElement.toLowerCase().charAt(iElement.length() - 1) == jElement.toLowerCase().charAt(0)) {
                        stringBuilder.append(" " + jElement);
                        iElement = list.get(i);
                        list.remove(i);
                        if (list.size() == i) {
                            i--;
                            if (i == 0) cicleNumber++;
                        }
                    } else {
                        i = i < list.size() - 1 ? i + 1 : 0;
                        if (i == 0) cicleNumber++;
                    }
                }
            } else {
                list = list1;
                Collections.shuffle(list1);
                cicleNumber = 0;
            }
        }
        return stringBuilder;
    }
}
