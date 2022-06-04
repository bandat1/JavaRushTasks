package com.javarush.task.task14.task1419;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.security.KeyException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        exceptions.add(new FileNotFoundException());
        exceptions.add(new FileSystemAlreadyExistsException());
        exceptions.add(new KeyException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new NullPointerException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new EOFException());


    }
}
