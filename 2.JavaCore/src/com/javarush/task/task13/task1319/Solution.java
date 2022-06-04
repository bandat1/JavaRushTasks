package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        //String a = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt";
        InputStream stream = System.in;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new Scanner(stream).nextLine()));
        Scanner console = new Scanner(stream);
        String line = null;

        while (true) {
            line = console.nextLine();
            bw.write(line + "\n");
            if (line.equals("exit")) {
                break;
            } else {
                continue;
            }
        }
        bw.close();
    }
}
