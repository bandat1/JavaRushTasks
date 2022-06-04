package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //C:\Users\denis\IdeaProjects\Test\file5.html
        String fileName;
        //String tag = args[0];
        StringBuilder stringBuilder = new StringBuilder("");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }
        }
        Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
        //Elements elements = document.select(tag);
        document.select("span").forEach(el -> System.out.println(el));
    }
}
