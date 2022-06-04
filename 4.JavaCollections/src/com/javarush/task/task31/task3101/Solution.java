package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0]; //путь к директории
        String resultFileAbsolutePath = args[1]; //имя (полный путь) существующего файла, который будет содержать результат

        File resultFile = new File(resultFileAbsolutePath);
        File newFile = new File(resultFile.getParentFile() + "/allFilesContent.txt");
        if (FileUtils.isExist(newFile)) {
            FileUtils.deleteFile(newFile);
        }
        FileUtils.renameFile(resultFile, newFile);
        File folder = new File(path);
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.close();
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            ArrayList<File> arr = checkDirectory(folder);
            for (File f : arr) {
                if (f.length() <= 50) {
                    try (FileInputStream inputStream = new FileInputStream(f)) {
                        byte[] buffer = new byte[inputStream.available()];
                        while (inputStream.available() > 0) {
                            inputStream.read(buffer);
                        }
                        fileOutputStream.write(buffer);
                        fileOutputStream.write('\n');
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList checkDirectory(File file) {
        ArrayList<File> list = new ArrayList<>();
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    ArrayList<File> subList = checkDirectory(f);
                    for (File fl : subList) {
                        list.add(fl);
                    }
                } else {
                    list.add(f);
                }
            }
        }
        return list;
    }
}
