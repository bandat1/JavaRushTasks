package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //"user", "loser", "coder", "proger"; тут цикл по чтению ключей, пункт 1
        while (true)
        {
//            System.out.println("Input smth: ");
            key = reader.readLine();
            if (key.equals("user")) {
                person = new Person.User();
            } else if (key.equals("loser")) {
                person = new Person.Loser();
            } else if (key.equals("coder")) {
                person = new Person.Coder();
            } else if (key.equals("proger")) {
                person = new Person.Proger();
            } else {
                break;
            }
            doWork(person); //вызываем doWork
            //создаем объект, пункт 2
        }
    }

    /**
     * Вызывает метод live() у переданного объекта, если этот объект (person) имеет тип User.
     * Вызывает метод doNothing(), если person имеет тип Loser.
     * Вызывает метод writeCode(), если person имеет тип Coder.
     * Вызывает метод enjoy(), если person имеет тип Proger.
     * @param person
     */
    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
