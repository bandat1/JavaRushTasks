package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    //напишите тут ваш код

    public static int max(int i, int o) {
        if (o > i)
            return o;
        return i;
    }

    public static int max(int i, int o, int p) {
        int y = i;
        if (o >= i) {
            y = o >= p ? o : p;
        }
        else if (o <= i) {
            y = i > p ? i : p;
        }
        return y;
    }

    public static int max(int i, int o, int p, int l) {
        int a = i >= o ? i : o;
        int u = p >= l ? p : l;
        int y = a >= u ? a : u;

        return y;
    }

    public static int max(int i, int o, int p, int l, int k) {
        int a = i >= o ? i : o;
        int u = p >= l ? p : l;
        int f = a >= u ? a : u;
        int y = f >= k ? f : k;

        return y;
    }

    public static int min(int i, int o) {
        int y = i >= o ? o : i;

        return y;
    }

    public static int min(int i, int o, int p) {
        int y = i;
        if (o >= i) {
            y = i >= p ? p : i;
        }
        else if (o < i) {
            y = o >= p ? p : o;
        }
        return y;
    }

    public static int min(int i, int o, int p, int l) {
        int a = i >= o ? o : i;
        int u = p >= l ? l : p;
        int y = a >= u ? u : a;

        return y;
    }

    public static int min(int i, int o, int p, int l, int k) {
        int a = i >= o ? o : i;
        int u = p >= l ? l : p;
        int f = a >= u ? u : a;
        int y = f >= k ? k : f;

        return y;
    }
}
