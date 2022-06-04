package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

/**
 * @author denis
 */

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16, (collection.size()/.75f) + 1);
        this.map = new HashMap<>(capacity);
        addAll(collection);
    }

    public boolean add(E e) {
        Object value = map.put(e, PRESENT);
        if (value ==null) return true;
        return false;
        }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
