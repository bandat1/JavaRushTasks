package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        String[] str1 = url.split("[?]");
/*        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i]);
        }
        System.out.println("=======");*/
        String[] str = str1[1].split("[&]");
  /*      for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
*/
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i].contains("=")) {
                String[] s = str[i].split("[=]");
                map.put(s[0], s[1]);
                System.out.println(s[0]);
            } else {
                map.put(str[i], "0");
                System.out.println(str[i]);
            }
        }
        for (String s : map.keySet()) {
            try {
                if (s.equals("obj")) {
                    alert(Double.valueOf(map.get(s)));
                }
            } catch (NumberFormatException e) {
                alert(map.get(s));
            }
        }

        reader.close();
    }



    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
