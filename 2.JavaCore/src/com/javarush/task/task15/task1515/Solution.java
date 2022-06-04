package com.javarush.task.task15.task1515;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    static {
        InputStream stream = System.in;
        InputStreamReader reader = null;
        BufferedReader buff = null;
        try {
            reader = new InputStreamReader(stream);
            buff = new BufferedReader(reader);
            A = Integer.parseInt(buff.readLine());
            B = Integer.parseInt(buff.readLine());
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
