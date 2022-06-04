package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту
*/

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
/*        Student s1 = (Student) o1;
        Student s2 = (Student) o2;*/
        int difference = s1.getAge() - s2.getAge();
        if (difference == 0) {
            return 0;
        } else if (difference > 0) {
            return -1;
        }
        return 1;
    }
}
