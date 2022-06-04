package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

/* 
Поиграем?
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        //показывает, найден победитель или нет.
        public static volatile boolean isWinnerFound = false;

        //хранит последовательность действий, которое каждый игрок выполняет от 0 до последнего.
        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        /**
         * 2.1. Через равные интервалы времени (1000ms / rating) выводились в консоль действия, описанные в steps.
         * 2.2. Любой текст должен начинаться с фамилии игрока (метод getName()), потом следовать двоеточие, а затем
         * сам текст.
         * 2.3. Когда игрок выполнит все действия из steps, то он считается победителем.
         * Выведи getName() + ":победитель!"
         * 2.4. Когда найден победитель, то игра останавливается, и остальные игроки считаются побежденными.
         * Выведи для них getName() + ":проиграл"
         */
        @Override
        public void run() {
            //Add your code here - добавь код тут
            try {
                for (String str : OnlineGame.steps) {
                    System.out.println(getName() + ":" + str);
                    Thread.sleep(1000 / this.rating);
                }
                if (!OnlineGame.isWinnerFound) {
                    OnlineGame.isWinnerFound = true;
                    System.out.println(getName() + ":победитель!");
                }
//                this.join();
            }
            catch (InterruptedException e) {
                System.out.println(getName() + ":проиграл");
            }
        }
    }
}
