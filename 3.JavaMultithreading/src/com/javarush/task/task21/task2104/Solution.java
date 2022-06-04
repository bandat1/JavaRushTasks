package com.javarush.task.task21.task2104;

import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == this) return true;
        if (!(n instanceof Solution)) return false;
        Solution solution = (Solution) n;
        boolean firstEquals = (this.first == null && solution.first == null)
                || (this.first != null && this.first.equals(solution.first));
        System.out.println("firstEquals = " + firstEquals);
        boolean lastEquals = (this.last == null && solution.last == null)
                || (this.last != null && this.last.equals(solution.last));
        System.out.println("firstEquals = " + lastEquals);

        return firstEquals && lastEquals;
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
