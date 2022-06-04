package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        //String str = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(sourceFileName);
             Scanner sc = new Scanner(fileInputStream);
        )
        {
            while (sc.hasNextInt()) {
                arrayList.add(sc.nextInt());
            }

            ArrayList<Integer> arr = new ArrayList<>(arrayList);
            for (Integer i : arr) {
                if (i % 2 != 0) {
                    arrayList.remove(i);
                }
            }
            Collections.sort(arrayList, (i1, i2) -> i1 - i2);
            for (Integer i : arrayList) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
