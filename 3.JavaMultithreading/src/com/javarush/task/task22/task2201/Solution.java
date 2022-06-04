package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/

public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    /**
     * 1. Метод getPartOfString должен возвращать подстроку между первой и последней табуляцией.
     * 2. На некорректные данные getPartOfString должен бросить исключение:
     * а) StringForFirstThreadTooShortException, если имя трэда FIRST_THREAD_NAME.
     * б) StringForSecondThreadTooShortException, если имя трэда SECOND_THREAD_NAME.
     * в) RuntimeException в других случаях.
     * @param string
     * @param threadName
     * @return
     */
    public synchronized String getPartOfString(String string, String threadName) {
        try {
            int firstT = string.indexOf("\t");
            int lastT = string.lastIndexOf("\t");
            if (firstT == -1 || lastT == -1) {
                throw new StringIndexOutOfBoundsException();
            } else {
                return string.substring(firstT + 1, lastT);
            }
        } catch (StringIndexOutOfBoundsException e) {
            if (threadName.equals(FIRST_THREAD_NAME)) {
                throw new StringForFirstThreadTooShortException(e);
            } else if (threadName.equals(SECOND_THREAD_NAME)) {
                throw new StringForSecondThreadTooShortException(e);
            } else {
                throw new RuntimeException();
            }
        }
    }
}
