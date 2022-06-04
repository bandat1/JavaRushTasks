package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(console);
        String[] strings = stream.toString().split(" ");
        int first = Integer.parseInt(strings[0]);
        int second = Integer.parseInt(strings[2]);
        StringBuilder result = new StringBuilder(stream.toString().strip()).append(" ");
        switch (strings[1]) {
            case "-":
                result.append(first - second);
                break;
            case "+":
                result.append(first + second);
                break;
            case "*":
                result.append(first * second);
                break;
        }
        System.out.println(result.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

