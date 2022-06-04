package com.javarush.task.pro.task16.task1606;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
Выход из зацикленности
*/

public class Solution {

    public static void main(String[] args) {
        Calendar start = new GregorianCalendar(2014, Calendar.JANUARY, 31);
        Calendar end = new GregorianCalendar(2014, Calendar.FEBRUARY, 2);

        System.out.print("Day = " + start.get(Calendar.DAY_OF_MONTH));
        System.out.print("Старт");
//        while (start.before(end)) {
        start.roll(Calendar.DATE, 1);
        System.out.print("Day = " + start.get(Calendar.DAY_OF_MONTH));
  //      }
        System.out.print("Финиш");
    }
}
