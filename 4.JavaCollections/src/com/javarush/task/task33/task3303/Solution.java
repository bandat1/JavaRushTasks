package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/

public class Solution {
    /**
     * @param fileName - приходит имя файла, который содержит один ДЖЕЙСОН объект
     * @param clazz - приходит имя класса, объект которого находится в файле.
     * @param <T>
     * @return - должен вычитать объект из файла, преобразовать его из JSON и вернуть
     * @throws IOException
     */
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileReader(new File(fileName)), clazz);

    }

    public static void main(String[] args) {

    }
}
