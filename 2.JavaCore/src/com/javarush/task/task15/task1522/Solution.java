package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    //add static block here - добавьте статический блок тут

    /**
     * Реализовать функционал метода readKeyFromConsoleAndInitPlanet():
     * для этого считай с консоли один параметр типа String.
     * если он равен одной из констант интерфейса Planet, создай соответствующий объект и присвой его Planet thePlanet,
     * иначе — обнули Planet thePlanet.
     */
    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in))) {
            String str = buff.readLine();
            if (str.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
            } else if (str.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();
            } else if (str.equals(Planet.SUN)) {
                thePlanet = Sun.getInstance();
            } else {
                thePlanet = null;
            }
        } catch (IOException e) {

        }
    }
}
