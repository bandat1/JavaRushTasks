package com.javarush.task.pro.task13.task1303;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* 
Выводим в консоли элементы множества
*/

public class Solution {

    public static void print(HashSet<String> words) {
        Iterator<String> it = words.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {
        String[] b = ("Программированию обычно учат на примерах.".split(" "));
        List<String> a = Arrays.asList(b);
        HashSet<String> words = new HashSet<>(a);
        print(words);
    }
}
