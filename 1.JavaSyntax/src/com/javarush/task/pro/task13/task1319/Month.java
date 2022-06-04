package com.javarush.task.pro.task13.task1318;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    //напишите тут ваш код

    public static Month[] getWinterMonths() {
        Month[] months = Month.values();
        Month[] winterMonths = new Month[3];
        for (Month month : months) {
            switch (month)
            {
                case JANUARY: winterMonths[0] = month;
                case FEBRUARY: winterMonths[1] = month;
                case DECEMBER: winterMonths[2] = month;
            }
        }
        return winterMonths;
    }

    public static Month[] getSpringMonths() {
        Month[] months = Month.values();
        Month[] springMonths = new Month[3];
        for (Month month : months) {
            switch (month)
            {
                case MARCH: springMonths[0] = month;
                case APRIL: springMonths[1] = month;
                case MAY: springMonths[2] = month;
            }
        }
        return springMonths;
    }

    public static Month[] getSummerMonths() {
        Month[] months = Month.values();
        Month[] summerMonths = new Month[3];
        for (Month month : months) {
            switch (month)
            {
                case JUNE: summerMonths[0] = month;
                case JULY: summerMonths[1] = month;
                case AUGUST: summerMonths[2] = month;
            }
        }
        return summerMonths;
    }

    public static Month[] getAutumnMonths() {
        Month[] months = Month.values();
        Month[] autumnMonths = new Month[3];
        for (Month month : months) {
            switch (month)
            {
                case SEPTEMBER: autumnMonths[0] = month;
                case OCTOBER: autumnMonths[1] = month;
                case NOVEMBER: autumnMonths[2] = month;
            }
        }
        return autumnMonths;
    }


}
