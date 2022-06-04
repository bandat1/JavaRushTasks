package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);

        testString.printSomething();

        List<String> array = new ArrayList(Arrays.asList(byteArrayOutputStream.toString().split("\n")));
        if (array!= null && array.size() >= 2) {
            for (int i = 2; i < array.size(); i += 3) {
                array.add(i, "JavaRush - курсы Java онлайн");
            }
        }

        System.setOut(console);
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
