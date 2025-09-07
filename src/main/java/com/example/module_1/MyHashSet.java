package com.example.module_1;

import java.util.HashMap;

public class MyHashSet<T> {
    private HashMap<T,Object> map;
    private static final Object VALUE = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public boolean add(T t) {
        return map.put(t, VALUE)==null;
    }

    public boolean remove(T t) {
        return map.remove(t)==VALUE;
    }
}
