package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        try {
            if (string.equals(null)) throw new TooShortStringException();
            StringBuilder stringBuilder = new StringBuilder(string);
            ArrayList<Integer> countOfSpaces = new ArrayList<>();
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == ' ') countOfSpaces.add(i);
            }
            if (countOfSpaces.size() < 4) {
                throw new TooShortStringException();
            } else {
                if (countOfSpaces.size() > 4) {
                    return string.substring(countOfSpaces.get(0) + 1, countOfSpaces.get(4));
                } else {
                    return string.substring((countOfSpaces.get(0) + 1));
                }
            }
        } catch (NullPointerException e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
