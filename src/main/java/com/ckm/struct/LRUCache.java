package com.ckm.struct;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LRUCache {
    int capacity;
    Map<Integer, Integer> elements;
    Queue<Integer> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.elements = new HashMap<>();
        this.queue = new LinkedBlockingQueue<>();
    }

    public int get(int key) {
        if (elements.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
        }
        return elements.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (elements.size() >= capacity && !elements.containsKey(key)) {
            int eleToRemove = queue.poll();
            elements.remove(eleToRemove);
        }
        elements.put(key, value);
        if (elements.containsKey(key)) {
            get(key);
        } else {
            queue.add(key);
        }
    }
}