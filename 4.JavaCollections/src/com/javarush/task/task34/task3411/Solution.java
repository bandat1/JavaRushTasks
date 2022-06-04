package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public final static String move = "from %s to %s\n";
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
        /*
        from A to B
        from A to C
        from B to C
        from A to B
        from C to A
        from C to B
        from A to B
                 */
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings < 1) return;
        if (numRings == 1) {
            System.out.printf(move, a, b);
        } else {
            moveRing(a, c, b, numRings - 1);
            System.out.printf(move, a, b);
            moveRing(b, c, a, numRings - 1);
        }

    }
}