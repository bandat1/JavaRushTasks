package com.javarush.task.task21.task2113;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author denis
 */
public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse h : getHorses()) {
            h.move();
        }
    }

    public void print(){
        for (Horse h : getHorses()) {
            h.print();
        }
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
    }

    public Horse getWinner(){
        Horse horse = getHorses().get(0);
        for (int i = 1; i < getHorses().size(); i++) {
            Horse h = getHorses().get(i);
            if (h.getDistance() > horse.getDistance()) horse = h;
        }
        return horse;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("aName", 3, 0));
        horses.add(new Horse("bName", 3, 0));
        horses.add(new Horse("cName", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
