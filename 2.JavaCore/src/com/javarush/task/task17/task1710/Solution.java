package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        /**
         * "-c Миронов м 15/04/1990"
         * -c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
         */
        if (args[0].equals("-c")) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = dateFormatter.parse(args[3]);
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], date));
            } else {
                allPeople.add(Person.createFemale(args[1], date));
            }
            System.out.println(allPeople.size() - 1);
        }
        //-r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
        if (args[0].equals("-r")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String date = dateFormat.format(person.getBirthDate());
            String male = person.getSex().equals(Sex.MALE) ? "м" : "ж";
            System.out.println(person.getName() + " " + male + " " + date);
        }
        //-u - обновляет данные человека с данным id
        if (args[0].equals("-u")) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Person person = allPeople.get(Integer.parseInt(args[1]));
            Date date = dateFormatter.parse(args[4]);
            person.setName(args[2]);
            person.setBirthDate(date);
            if (args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else {
                person.setSex(Sex.FEMALE);
            }
        }
        //-d - производит логическое удаление человека с id, заменяет все его данные на null
        if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setSex(null);
            person.setBirthDate(null);
            person.setName(null);
            allPeople.remove(args[1]);
        }
    }
}
