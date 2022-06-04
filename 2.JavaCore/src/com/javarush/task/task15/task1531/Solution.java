package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static String factorial(int n) {
        //add your code here
        BigDecimal f = new BigDecimal(1.0);
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                f = f.multiply(new BigDecimal(i));
            }
        }
        if (n < 0) {
            f = new BigDecimal(0.0);
        }

        return f.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

}
