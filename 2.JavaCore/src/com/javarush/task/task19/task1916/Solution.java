package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {

    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> list1;
        ArrayList<String> list2;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            list1 = readAllLines(bufferedReader.readLine());
            list2 = readAllLines(bufferedReader.readLine());
        }
        while (true) {
                if (list1.size() != 0 && list2.size() != 0) {
                    if (list1.get(0).equals(list2.get(0))) {
                        lines.add(new LineItem(Type.SAME, list1.get(0)));
                        list1.remove(0);
                        list2.remove(0);
                    } else if (list1.get(1).equals(list2.get(0))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                        list1.remove(0);
                    } else if (list1.get(0).equals(list2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
                        list2.remove(0);
                    }
                } else if (list2.size() != 0 && list1.size() == 0) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                } else if (list1.size() != 0 && list2.size() == 0) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                } else break;
        }
    }

    private static ArrayList<String> readAllLines(String fileName) throws IOException {
        ArrayList<String> array = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                array.add(line);
            }
            return array;
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
