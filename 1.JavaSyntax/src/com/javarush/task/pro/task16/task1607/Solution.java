package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код
        return LocalDate.now();

    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        return LocalDate.of(2020, 9, 12);

    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        LocalDate day = LocalDate.of(2020, 9, 12);
        int dayOfYear = day.getDayOfYear();
        return LocalDate.ofYearDay(2020, dayOfYear);
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        LocalDate day = LocalDate.of(2020, 9, 12);
        System.out.println("-----------");
        /*System.out.println(day);
        System.out.println(epoch);*/
        //LocalDate EPOCH_DAY = LocalDate.ofEpochDay(0);
        long difference = DAYS.between(LocalDate.ofEpochDay(0), day);
        System.out.println("---------");
        System.out.println(difference);
        System.out.println("---------");
        return  LocalDate.ofEpochDay(difference);

    }
}
