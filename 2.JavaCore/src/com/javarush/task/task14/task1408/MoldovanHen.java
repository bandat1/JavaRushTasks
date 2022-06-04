package com.javarush.task.task14.task1408;

/**
 * @author denis
 */
public class MoldovanHen extends Hen implements Country {
    @Override
    public int getCountOfEggsPerMonth() {
        return 30;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " +  MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
