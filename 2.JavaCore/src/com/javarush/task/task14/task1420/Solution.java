package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Integer num1 = Integer.valueOf(scanner.nextLine());
        Integer num2 = Integer.valueOf(scanner.nextLine());
        scanner.close();
        int nod = 1;

        for (int i = Integer.min(num1, num2); i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                nod = i;
                break;
            }
        }

        System.out.println(nod);
    }
}
