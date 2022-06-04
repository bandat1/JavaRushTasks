package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Solution)) return false;
        Solution n = (Solution) o;
        boolean firstEquals = (this.first == null && n.first == null)
                || (this.first != null && this.first.equals(n.first));
        boolean secondEquals = (this.last == null && n.last == null)
                || (this.last != null && this.last.equals(n.last));
        return firstEquals && secondEquals;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
