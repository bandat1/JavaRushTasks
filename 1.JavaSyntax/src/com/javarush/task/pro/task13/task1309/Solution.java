package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("First student", 5.0);
        grades.put("Second student", 5.0);
        grades.put("Third student", 5.0);
        grades.put("Forth student", 5.0);
        grades.put("Five student", 5.0);
    }
}
