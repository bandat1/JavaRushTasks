package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String arg0 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String arg1 = new BufferedReader(new InputStreamReader(System.in)).readLine();*/
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            StringBuilder stringBuilder = new StringBuilder("");
            while (reader.ready()) {
                String[] words = reader.readLine().split(" ");
                for (String word : words) {
                    char[] ch = word.toCharArray();
                    for (int i = 0; i < ch.length; i++) {
                        if (Character.isDigit(ch[i])) {
                            stringBuilder.append(word + " ");
                            break;
                        }
                    }
                }
            }
            fileWriter.write(stringBuilder.toString().trim());
        }
    }
}
