package com.javarush.task.task14.task1408;

/**
 * @author denis
 */
public class BelarusianHen extends Hen implements Country{
    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    /**
     * <getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">
     * где Sssss - название страны
     * где N - количество яиц в месяц
     * @return
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " +  BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
