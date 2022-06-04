package com.javarush.task.pro.task14.task1414;

/* 
Готовим коктейли
*/

//import sun.jvm.hotspot.StackTrace;

public class Solution {

    public static final String OUTPUT_FORMAT = "Метод %s вызван из строки %d класса %s в файле %s.\n";

    public static void main(String[] args) {
        makeScrewdriver();
    }

    public static void printStackTrace(StackTraceElement[] stackTrace) {
        //напишите тут ваш код
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement a = stackTrace[i];
            System.out.printf(OUTPUT_FORMAT, a.getMethodName(), a.getLineNumber(), a.getClassName(), a.getFileName());
/*            System.out.println(
                    "Метод " + stackTrace[i].getMethodName() + " вызван из строки " +
                    stackTrace[i].getLineNumber() + " класса " + stackTrace[i].getClassName() + " в файле " +
                    stackTrace[i].getFileName() + "."
            );*/
        }
    }

    static void makeScrewdriver() {
        addJuice();
    }

    static void addJuice() {
        addVodka();
    }

    static void addVodka() {
        printStackTrace(Thread.currentThread().getStackTrace());
    }
}
