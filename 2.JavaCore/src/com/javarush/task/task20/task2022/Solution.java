package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;

    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        //сюда будем сохранять текст
        String textFilePath = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.txt";
        //сюда будем сохранять сериализуемый/десериализуемый объект
        String objectFilePath = "C:\\Users\\denis\\IdeaProjects\\Test\\file1.bin";

        //создаем объект
        Solution solution = new Solution(textFilePath);
        //вызываем методы записи в файл у объекта (запись в файл .txt)
        solution.writeObject("Hello 1");
        solution.writeObject("Hello 2");

        //создаем поток записи объектов в файл .bin
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(objectFilePath));
        //записываем объект
        out.writeObject(solution);

        solution.close();
        out.close();


        FileInputStream inputStream = new FileInputStream(objectFilePath);
        //создаем поток чтения объектов из файла .bin
        ObjectInputStream in = new ObjectInputStream(inputStream);
        //считываем объект из файла и присваиваем значение переменной
        Solution newSolution = (Solution) in.readObject();
        //для считанного объекта вызываем методы записи в файл (запись в файл .txt)
        newSolution.writeObject("Hello 3");

        newSolution.close();
        in.close();
    }
}
