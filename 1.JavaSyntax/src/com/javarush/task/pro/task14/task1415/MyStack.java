package com.javarush.task.pro.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new ArrayList<>();

    public void push(String s) {
        //напишите тут ваш код
        storage.add(0, s);
    }

    public String pop() {
        //напишите тут ваш код
        String str = peek();
        storage.remove(str);
        return str;
    }

    public String peek() {
        //напишите тут ваш код
        String str = storage.get(0);
        return str;
    }

    public boolean empty() {
        //напишите тут ваш код
        return (storage.isEmpty() ? true : false);
    }

    public int search(String s) {
        //напишите тут ваш код
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i) == s) {
                return i;
            }
        }
        return -1;
    }
}
