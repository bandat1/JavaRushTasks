package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    /**
     * Для каждого значения, кроме "exit", вызвать метод print(). Если значение:
     * содержит точку '.', вызвать метод print() для Double;
     * больше нуля, но меньше 128, вызвать метод print() для short;
     * меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer;
     * иначе — вызвать метод print() для String.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while (!((str = buff.readLine()).equals("exit"))) {
            try {
                if (str.contains(".")) {
                    print(Double.valueOf(str));
                } else if (Integer.valueOf(str) > 0 && Integer.valueOf(str) < 128) {
                    print(Short.valueOf(str));
                } else if ((Integer.valueOf(str) <= 0 || Integer.valueOf(str) >= 128)) {
                    print(Integer.valueOf(str));
                }
             } catch (NumberFormatException e) {
                print(str);
                continue;
            }
        }
        buff.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
