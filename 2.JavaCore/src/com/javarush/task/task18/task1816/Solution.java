package com.javarush.task.task18.task1816;

import javax.security.auth.login.AccountLockedException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String mode = args[0];
        int count = 0;
        if (mode.length() != 0) {
            BufferedReader reader = new BufferedReader(new FileReader(mode));
            while (reader.ready()) {
                String line = reader.readLine();
                for (char c : line.toCharArray()) {
                    int ch = (int) c;
                    if ((ch >= 65 && ch <= 90) || (ch >= 91 && ch <= 122)) count++;
                }
            }
            System.out.println(count);
            reader.close();
        }
    }
}
