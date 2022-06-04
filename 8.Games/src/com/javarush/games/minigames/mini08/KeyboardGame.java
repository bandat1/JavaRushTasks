package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    //напишите тут ваш код


    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            paintRow(0, 1);
        }
        else if (key == Key.RIGHT) {
            paintRow(2, 1);
        }
        else if (key == Key.UP) {
            paintRow(0, 0);
        }
        else if (key == Key.DOWN) {
            paintRow(2, 0);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.DOWN || key == Key.UP || key == Key.LEFT || key == Key.RIGHT) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    setCellColor(x, y, Color.WHITE);
                }
            }
        }
    }

    private void paintRow(int row, int direction) {
        for (int i = 0; i < 3; i++) {
            if (direction == 0) { //horizontal
                setCellColor(i, row, Color.GREEN);
            } else if (direction == 1) { //vertical
                setCellColor(row, i, Color.GREEN);
            } else {
                System.out.println("Ошибка ввода");
            }
        }
    }
}
