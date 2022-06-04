package com.javarush.task.pro.task13.task1307;

import java.sql.SQLOutput;
import java.util.*;

/* 
Изучаем методы класса Collections, часть 2
*/

public class Solution {

    public static void reverse(ArrayList<Integer> list) {
/*        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++) {
            Integer integer = list.get(i);
            list.set(i, list.get(j - i));
            list.set(j - i, integer);
        }
        System.out.println(list);*/
        Collections.reverse(list);
    }

    public static void sort(ArrayList<Integer> list) {
/*        int n = list.size();
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (list.get(j - 1) > list.get(j)) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list);*/
        Collections.sort(list);
    }

    public static void rotate(ArrayList<Integer> list, int distance) {
/*        for (int i = 0; i < distance; i++) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        System.out.println(list);*/
        Collections.rotate(list, distance);
    }

    public static void shuffle(ArrayList<Integer> list) {
/*        Random rand = new Random();
        for (int i = 0; i < list.size(); i++) {
            int randomIndexToSwap = rand.nextInt(list.size());
            int temp = list.get(randomIndexToSwap);
            list.set(randomIndexToSwap, list.get(i));
            list.set(i, temp);
        }
        System.out.println(list);*/
        Collections.shuffle(list);
    }
}
