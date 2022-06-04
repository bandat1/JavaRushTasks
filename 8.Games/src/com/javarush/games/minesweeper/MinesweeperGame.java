package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

/**
 * @author denis
 */
public class MinesweeperGame extends Game {
    @Override
    public void initialize() {

        //  Создаем игровое поле 3x3 клетки
        setScreenSize(3, 3);
        //  Выключаем отображение сетки
        showGrid(false);
        //  Меняем фон центральной клетки на синий, и отображаем в ней “Х”
        setCellValueEx(1, 1, Color.BLUE, "X", Color.ORANGE, 50);
    }
}
