package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Collections.sort;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
        Scanner scanner = new Scanner(input);
        String path = scanner.nextLine();
        try (FileInputStream file = new FileInputStream(path)) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (file.available() > 0) {
                arrayList.add(file.read());
            }
            arrayList.stream()
                    .sorted()
                    .distinct()
                    .forEach((i) -> System.out.print(i + " "));
        }
    }
}
