package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        File folder = new File(root);
        Queue<File> queue = new PriorityQueue<>();
        for (File file : folder.listFiles()) {
            queue.add(file);
        }
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (!file.isDirectory()) {
                list.add(file.getAbsolutePath());
            } else {
                for (File f : file.listFiles()) {
                    queue.add(f);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
