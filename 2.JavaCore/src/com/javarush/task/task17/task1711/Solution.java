package com.javarush.task.task17.task1711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.javarush.task.task17.task1711.Sex.FEMALE;
import static com.javarush.task.task17.task1711.Sex.MALE;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        /**
         * -c name1 sex1 bd1 name2 sex2 bd2 ...
         * -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
         * -d id1 id2 id3 id4 ...
         * -i id1 id2 id3 id4 ...
         *
         * Значения параметров:
         * name - имя, String
         * sex - пол, "м" или "ж", одна буква
         * bd - дата рождения в следующем формате 15/04/1990
         * -с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в
         * соответствующем порядке
         * -u - обновляет соответствующие данные людей с заданными id
         * -d - производит логическое удаление человека с id, заменяет все его данные на null
         * -i - выводит на экран информацию о всех людях с заданными id: name sex bd
         */
        // добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в
        // соответствующем порядке
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i += 3) {
                        Date date = dateFormatter.parse(args[i + 2]);
                        if (args[i + 1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], date));
                        } else {
                            allPeople.add(Person.createFemale(args[i], date));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
            }
                break;
        }

        //выводит на экран информацию о всех людях с заданными id: name sex bd
        switch (args[0]) {
            case "-i":
                synchronized (allPeople) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        String date = dateFormat.format(person.getBirthDate());
                        String male = person.getSex().equals(MALE) ? "м" : "ж";
                        System.out.println(person.getName() + " " + male + " " + date);
                    }
                }
                break;
        }

        switch (args[0]) {
            case "-u": {
                synchronized (allPeople) {
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i += 4) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        Date date = dateFormatter.parse(args[i + 3]);
                        person.setName(args[i + 1]);
                        person.setBirthDate(date);
                        if (args[i + 2].equals("м")) {
                            person.setSex(MALE);
                        } else {
                            person.setSex(FEMALE);
                        }
                    }
                }
                break;
            }
        }

        switch (args[0]) {
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setSex(null);
                        person.setBirthDate(null);
                        person.setName(null);
                        allPeople.remove(args[i]);
                    }
                }
                break;
        }
    }
}
