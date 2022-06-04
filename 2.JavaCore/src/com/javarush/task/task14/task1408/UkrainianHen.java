package com.javarush.task.task14.task1408;

/**
 * @author denis
 */
public class UkrainianHen extends Hen implements Country {
    @Override
    public int getCountOfEggsPerMonth() {
        return 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " +  UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
