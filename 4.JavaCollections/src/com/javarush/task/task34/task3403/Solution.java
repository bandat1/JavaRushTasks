package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

import static java.lang.Math.sqrt;

public class Solution {

    public void recurse(int n) {
        if (n <= 1) return;
        if (isPrime(n)) {
            System.out.print(n);
            return;
        }
        int s = n / 2;
        for (int i = 2; i <= s; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                s = n / i;
                break;
            }
        }
        recurse(s);

    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        int s = (int) sqrt(n);
        for (int i = 2; i <= s; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
