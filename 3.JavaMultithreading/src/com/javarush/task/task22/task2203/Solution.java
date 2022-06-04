package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int firstT = string.indexOf("\t");
            int secondT = string.indexOf("\t", firstT + 1);
            if (firstT == -1 || secondT == -1) {
                throw new TooShortStringException();
            } else {
                return string.substring(firstT + 1, secondT);
            }
        } catch (NullPointerException e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        //System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString(null));
    }
}
