package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

/**
 * @author denis
 */
public class Game2048 extends Game {
    //Размер стороны экрана
    private static final int SIDE = 4;
    //Массив со значениями всех полей
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score;

    /**
     * Создаем игру
     */
    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    /**
     * Закрашиваем все поля в одинаковый фиксированный цвет. В данном случае - белый.
     */
    private void drawScene() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField.length; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    /**
     * Создаем новое число (2 или 4) и сохраняем это число в рандомной пустой ячейке.
     * Число 2 создается с вероятность 90%, число 4 - с вероятность 10%.
     */
    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
        } else {
            while (true) {
                int tempX = getRandomNumber(SIDE);
                int tempY = getRandomNumber(SIDE);
                if (gameField[tempY][tempX] == 0) {
                    gameField[tempY][tempX] = getRandomNumber(10) == 9 ? 4 : 2;
                    break;
                }
            }
        }
    }

    /**
     * Отображаем значения в ячейках и закрашиваем ячейки с одинаковыми значениями в одинаковые цвета.
     * @param x - координата по X
     * @param y - координата по Y
     * @param value - значение ячейки (x, y)
     */
    private void setCellColoredNumber(int x, int y, int value) {
        if (value == 0) {
            setCellValueEx(x, y, getColorByValue(value), "");
        } else {
            setCellValueEx(x, y, getColorByValue(value), String.valueOf(value));
        }
    }

    /**
     * Получаем цвет ячейки по хранимому в ней значению
     * @param value - значнеие ячейки
     * @return
     */
    private Color getColorByValue(int value) {

        switch (value) {
            case 0: 
                return Color.WHITE;
            case 2: 
                return Color.PLUM;
            case 4: 
                return Color.PAPAYAWHIP;
            case 8: 
                return Color.LIGHTGREY;
            case 16: 
                return Color.GRAY;
            case 32: 
                return Color.BLUE;
            case 64: 
                return Color.BLUEVIOLET;
            case 128: 
                return Color.GREEN;
            case 256: 
                return Color.YELLOWGREEN;
            case 512: 
                return Color.YELLOW;
            case 1024: 
                return Color.ORANGE;
            case 2048: 
                return Color.RED;
            default: 
                return Color.NONE;
        }
    }

    /**
     * Сдвигаем все ненулевые элементы строки влево.
     * @param row - массив-строка
     * @return
     */
    private boolean compressRow(int[] row) {
        boolean checkStatus = false;
        for (int i = 0; i < row.length - 1; i++) {
            for (int j = 1; j < row.length; j++) {
                if (row[j - 1] == 0 && row[j] != 0) {
                    row[j - 1] = row[j];
                    row[j] = 0;
                    checkStatus = true;
                }
            }
        }
        return checkStatus;
    }

    /**
     * Складываем рядом лежащие ячейки с ненулевыми значениями в строке.
     * @param row - массив-строка
     * @return
     */
    private boolean mergeRow(int[] row) {
        boolean checkStatus = false;
        for (int i = 1; i < row.length; i++) {
            if (row[i] == row[i - 1] && row[i] != 0) {
                row[i - 1] *= 2;
                row[i] = 0;
                score += row[i - 1];
                checkStatus = true;
                setScore(score);
                i++;
            }
        }
        return checkStatus;
    }

    /**
     * При нажатии стрелки клавиатуры влево - сдвиг всех ячеек влево и складывае расположенных рядом ячеек с
     * одинаковыми значениями. При нажатии стрелки клавиатуры вправо, вверх или вниз - аналогичные действия
     * нажатию клавиши "влево", только в соответствующие стороны.
     * Если игра была завершена, то при нажатии пробела происходит рестарт игры.
     * При нажатии других клавиш ничего не происходит.
     * @param key - клавиша клавиатуры
     */
    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                score = 0;
                setScore(score);
                createGame();
                drawScene();
            }
            else {
                return;
            }
        }
        if (!canUserMove()) {
            gameOver();
            return;
        }
        if (key == Key.LEFT) {
            moveLeft();
        } else if (key == Key.RIGHT) {
            moveRight();
        } else if (key == Key.UP) {
            moveUp();
        } else if (key == Key.DOWN) {
            moveDown();
        } else {
            return;
        }
        drawScene();
    }

    /**
     * Сдвигаем все ячейки во всех строках влево. Лежащие рядом одинаковые значения складваем.
     * После совершенного движения создаем в рандомной пустой ячейке значение.
     */
    private void moveLeft() {
        boolean checkStatus = false;
        for (int y = 0; y < gameField.length; y++) {
            if (compressRow(gameField[y]) | mergeRow(gameField[y])){
                compressRow(gameField[y]);
                checkStatus = true;
            }
        }
        if (checkStatus) {
            createNewNumber();
        }
    }

    /**
     * Сдвигаем все ячейки во всех строках вправо. Лежащие рядом одинаковые значения складваем.
     * После совершенного движения создаем в рандомной пустой ячейке значение.
     */
    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    /**
     * Сдвигаем все ячейки во всех строках вверх. Лежащие рядом одинаковые значения складваем.
     * После совершенного движения создаем в рандомной пустой ячейке значение.
     */
    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    /**
     * Сдвигаем все ячейки во всех строках вниз. Лежащие рядом одинаковые значения складваем.
     * После совершенного движения создаем в рандомной пустой ячейке значение.
     */
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    /**
     * Поворот матрицы на 90 градусов по часовой стрелке. Пример:
     * (2, 2, 2, 2),    (0, 8, 4, 2),
     * (4, 4, 4, 4), => (0, 8, 4, 2),
     * (8, 8, 8, 8),    (0, 8, 4, 2),
     * (0, 0, 0, 0),    (0, 8, 4, 2)
     */
    private void rotateClockwise() {
        int[][] result = new int[gameField.length][gameField.length];
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField.length; x++) {
                result[x][gameField.length - y - 1] = gameField[y][x];
            }
        }
        gameField = result;
    }

    /**
     * Получаем максимальное значение в матрице.
     * @return
     */
    private int getMaxTileValue() {
        int max = gameField[0][0];
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField.length; x++) {
                if (gameField[y][x] > max) {
                    max = gameField[y][x];
                }
            }
        }
        return max;
    }

    /**
     * Отображение экрана победы.
     */
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTGREY, "You WIN!", Color.RED, 70);
    }

    /**
     * Проверка, есть ли ячейки со значением 0. Если таких нет, то проверка, возможно ли движение ячеек.
     * @return
     */
    private boolean canUserMove() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField.length; x++) {
                if (gameField[y][x] == 0) {
                    return true;
                }
                if (y < gameField.length - 1 && gameField[y][x] == gameField[y + 1][x]) {
                    return true;
                } else if (x < gameField.length - 1 && gameField[y][x] == gameField[y][x + 1] ) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Отображение экрана проигрыша.
     */
    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.ROSYBROWN, "GAME OVER!", Color.RED, 80);
    }

    @Override
    public void initialize() {

        setScreenSize(SIDE, SIDE);

        createGame();
        drawScene();
    }
}
