package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        //String fileName = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt";
        String fileName = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] lineObjects = line.split(" ");
                int year = Integer.parseInt(lineObjects[lineObjects.length - 1]) - 1900;
                int month = Integer.parseInt(lineObjects[lineObjects.length - 2]) - 1;
                int day = Integer.parseInt(lineObjects[lineObjects.length - 3]);
                Date date = new Date(year, month, day);
                StringBuilder name = new StringBuilder("");
                for (int i = 0; i < lineObjects.length - 3; i++) {
                    name.append(lineObjects[i] + " ");
                }
                PEOPLE.add(new Person(name.toString().trim(), date));
            }
        }
    }
}
