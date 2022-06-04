package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/

public class Solution {
    //число S равно сумме его цифр, возведенных в M степень.
    public static long[] getNumbers(long N) {

    }

    private static long[] helpMethod(long N) {
        Set<Long> list = new HashSet<>();
        long i = 1;
        while (i < N) {
            int length = String.valueOf(i).length();
            if (length == 1) {
                list.add(i);
            } else {
                long sum = 0;
                for (char c : String.valueOf(i).toCharArray()) {
                    sum += Math.pow(Character.getNumericValue(c), length);

                }
                if (i == sum) {
                    list.add(i);
                }
                i++;
            }
        }
        long[] result = new long[list.size()];
        int j = 0;
        for (Long l : list) {
            result[j++] = l;
            //System.out.print(l + " : ");
        }

        return result;
    }

    private long[][] matrix(long N) {
        long[][] matrix = new long[10][String.valueOf(Long.MAX_VALUE).length()];
        int i = 1;
        while (i < 10) {
            long l = 1;
            while(l < N) {
                matrix[i][l] = Math.pow(i, l);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        //getNumbers(371);

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
