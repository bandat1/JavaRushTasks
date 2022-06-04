package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();
    //C:\Users\denis\IdeaProjects\Test\file2.txt
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.ready()) {
                stringBuilder.append(reader.readLine() + " ");
            }
            List<String> list = new ArrayList<>(Arrays.asList(stringBuilder.toString().split(" ")));
            for (int i = 0; i < list.size() - 1; i++) {
                String s = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    String ss = list.get(j);
                    if ((s.equals(new StringBuffer(ss).reverse().toString()) &&
                            ss.equals(new StringBuilder(s).reverse().toString())) || (s.equals(ss) &&
                            new StringBuffer(ss).reverse().toString().equals(new StringBuffer(s).reverse().toString())))
                    {
                        Pair pair = new Pair();
                        pair.first = s;
                        pair.second = ss;
                        result.add(pair);
                        list.remove(j);
                        break;
                    }
                }
            }
        }
        //System.out.println(result.toString());

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
