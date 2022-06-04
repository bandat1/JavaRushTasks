package com.javarush.task.pro.task16.task1615;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/* 
Ой как много методов!
*/

public class Solution {

    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(10);
        System.out.println(instant);
        System.out.println(plusMinutes(instant, 2));
        System.out.println(plusHours(instant, 2));
        System.out.println(plusDays(instant, 2));
        System.out.println(minusMinutes(instant, 2));
        System.out.println(minusHours(instant, 2));
        System.out.println(minusDays(instant, 2));
    }

    public final static long hoursPerDay = 24;
    public final static long minutesPerHour = 60;
    public final static long secondsPerMinute = 60;


    static public Instant plusMinutes(Instant instant, long minutes) {
        //напишите тут ваш код
        return instant.plusSeconds(minutes * secondsPerMinute);
    }

    static public Instant plusHours(Instant instant, long hours) {
        //напишите тут ваш код
        return instant.plusSeconds(hours * minutesPerHour * secondsPerMinute);
    }

    static public Instant plusDays(Instant instant, long days) {
        //напишите тут ваш код
        return instant.plusSeconds(days * hoursPerDay * minutesPerHour * secondsPerMinute);
    }

    static public Instant minusMinutes(Instant instant, long minutes) {
        //напишите тут ваш код
        return instant.minusSeconds(minutes * secondsPerMinute);
    }

    static public Instant minusHours(Instant instant, long hours) {
        //напишите тут ваш код

        return instant.minusSeconds(hours * minutesPerHour * secondsPerMinute);
    }

    static public Instant minusDays(Instant instant, long days) {
        //напишите тут ваш код

        return instant.minusSeconds(days * hoursPerDay * minutesPerHour * secondsPerMinute);
    }
}
