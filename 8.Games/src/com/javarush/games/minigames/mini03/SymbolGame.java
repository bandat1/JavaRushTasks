package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

import java.util.ArrayList;
import java.util.stream.Stream;

/* 
Простая программа
*/

public class SymbolGame extends Game {

    //напишите тут ваш код

    @Override
    public void initialize() {
        setScreenSize(8, 3);

        //final String javarush = "JAVARUSH";

        final ArrayList<String> javarush = new ArrayList<>();
        javarush.add("J");
        javarush.add("A");
        javarush.add("V");
        javarush.add("A");
        javarush.add("R");
        javarush.add("U");
        javarush.add("S");
        javarush.add("H");

        for (int i = 0; i < getScreenWidth(); i++) {
            setCellValueEx(i, 1, Color.ORANGE, javarush.get(i));
        }
        System.out.println(getScreenWidth());
    }
}
