package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static CanFly result;


    /**
     * В статическом методе reset() класса Solution:
     * считать с консоли параметр типа String;
     * если параметр равен "helicopter", статическому объекту CanFly result присвоить объект класса Helicopter;
     * если параметр равен "plane", считать второй параметр типа int (количество пассажиров), статическому объекту
     * CanFly result присвоить объект класса Plane.
     */
    public static void reset() throws IOException {
        //add your code here - добавьте код тут
       BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
       String str = buff.readLine();
       if (str.equals("helicopter")) {
           result = new Helicopter();
       } else if (str.equals("plane")) {
           int count = Integer.parseInt(buff.readLine());
           result = new Plane(count);
       }
       buff.close();
    }

    static {
        //add your code here - добавьте код тут

    }
}
