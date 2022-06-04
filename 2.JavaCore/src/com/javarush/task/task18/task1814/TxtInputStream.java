package com.javarush.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    /**
     * 1. Класс TxtInputStream должен наследоваться от класса FileInputStream.
     * 2. Если в конструктор передан txt-файл, TxtInputStream должен вести себя, как обычный FileInputStream.
     * 3. Если в конструктор передан не txt-файл, должно быть выброшено исключение UnsupportedFileNameException.
     * 4. В случае выброшенного исключения, так же должен быть вызван super.close().
     * @param fileName
     */
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!getFileExtension(fileName).equals("txt")) {
            super.close();
            throw  new UnsupportedFileNameException();
        };
    }

    private static String getFileExtension(String str) {
        int index = str.lastIndexOf('.');
        return index == -1? null : str.substring(index + 1);
    }

    public static void main(String[] args) {
        //getFileExtension("C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt");
    }
}

