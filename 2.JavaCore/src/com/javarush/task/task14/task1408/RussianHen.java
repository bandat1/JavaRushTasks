package com.javarush.task.task14.task1408;

/**
 * @author denis
 */
public class RussianHen extends Hen implements Country {
    @Override
    public int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " +  RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
