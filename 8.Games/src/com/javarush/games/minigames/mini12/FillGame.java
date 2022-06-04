package com.javarush.games.minigames.mini12;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

/* 
Работаем со списком координат
*/

public class FillGame extends Game {
    private final List<Cell> cells = new ArrayList<>();

    @Override
    public void initialize() {
        setScreenSize(10, 10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }
    //будет закрашивать нажатую клетку оранжевым цветом, и если в списке cells нет таких координат, добавлять их.
    @Override
    public void onMouseLeftClick(int x, int y) {
        //напишите тут ваш код
        setCellColor(x, y, Color.ORANGE);

        boolean existSameCoordinate = false;
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                existSameCoordinate = true;
            }
        }
        if (existSameCoordinate == false) {
            cells.add(new Cell(x, y));
        }
    }

    //должен закрашивать нажатую клетку белым цветом, и если координаты этой клетки есть в списке cells — удалить эту клетку из списка.
    @Override
    public void onMouseRightClick(int x, int y) {
        //напишите тут ваш код
        setCellColor(x, y, Color.WHITE);

        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                cells.remove(cell);
            }
        }
    }
}
