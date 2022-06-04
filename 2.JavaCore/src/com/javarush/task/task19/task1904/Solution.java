package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException {
            String[] line = fileScanner.nextLine().split(" ");
            String date = String.format("%s/%s/%s", line[line.length- 1], line[line.length- 2], line[line.length- 3]);
            return new Person(line[1], line[2], line[0], new Date(date));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
