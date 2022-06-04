package com.javarush.task.task15.task1529;

/**
 * @author denis
 */
public class Plane implements CanFly {
    @Override
    public void fly() {

    }

    private int count;
    public Plane(int count) {
        this.count = count;
    }
}
