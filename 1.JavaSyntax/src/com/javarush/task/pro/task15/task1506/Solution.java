package com.javarush.task.pro.task15.task1506;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        //String str1 = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt";
        //String str2 = "C:\\Users\\denis\\IdeaProjects\\Test\\file2.txt";

/*        Scanner scanner = new Scanner(System.in);
        Path path1 = Path.of(scanner.nextLine());
        //InputStream inputStream = Files.newInputStream(path1);
        List<String> list = Files.readAllLines(path1);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(" ") || list.get(i).equals(".") || list.get(i).equals(",")) {
                continue;
            } else {
                System.out.println(list.get(i));

            }
        }
        scanner.close();*/

        try (Scanner scanner = new Scanner(System.in)) {
            List<String> lines = Files.readAllLines(Paths.get(scanner.nextLine()));
            lines.forEach(str -> {
                char[] chars = str.toCharArray();
                for (char character : chars) {
                    if (character != ' ' && character != '.' && character != ',') {
                        System.out.print(character);
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

