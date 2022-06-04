package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        /**
         * 1. Метод run класса Stopwatch (секундомер) должен содержать цикл.
         * 2. Метод run должен вызывать Thread.sleep(1000).
         * 3. Метод run должен увеличивать значение поля seconds на 1 каждую секунду.
         * 4. После прерывания работы нити Stopwatch (вызова метода interrupt), метод run должен вывести количество
         * секунд (seconds) в консоль.
         */
        public void run() {
            try {
                //напишите тут ваш код
                while (true) {
                    Thread.sleep(1000);
                    seconds++;
                }
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}
