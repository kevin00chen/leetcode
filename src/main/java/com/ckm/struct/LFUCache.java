package com.ckm.struct;

import java.util.*;

/**
 * 按使用频率缓存
 */
public class LFUCache {
    int capacity;
    Map<Integer, Integer> elements;
    Map<Integer, Integer> frequency;
    Map<Integer, LinkedHashSet<Integer>> counter;


    public LFUCache(int capacity) {
        if (capacity <= 0) {
            return;
        } else {
            this.capacity = capacity;
            this.elements = new HashMap<>();
            this.frequency = new HashMap<>();
            this.counter = new HashMap<>();
        }
    }

    public int get(int key) {
        if (capacity <= 0) {
            return -1;
        }
        if (elements.containsKey(key)) {
            counter.get(frequency.get(key)).remove(key);
            if (counter.get(frequency.get(key)).isEmpty()) {
                counter.remove(frequency.get(key));
            }
            frequency.put(key, frequency.get(key) + 1);
            LinkedHashSet<Integer> set = counter.getOrDefault(frequency.get(key), new LinkedHashSet<>());
            set.add(key);
            counter.put(frequency.get(key), set);
        }
        return elements.getOrDefault(key, -1);
    }

    public void put(int key, int value) { // 多次`put`时需要调整顺序
        if (capacity <= 0) {
            return;
        }
        if (elements.size() >= capacity && !elements.containsKey(key)) {
            int minAccess = Collections.min(counter.keySet());
            LinkedHashSet<Integer> leastSet = counter.get(minAccess);
            int eleToRemove = (int) leastSet.toArray()[0]; // 移除元素时，移除头部
            if (leastSet.size() == 1) {
                counter.remove(minAccess);
            } else {
                leastSet.remove(eleToRemove);
            }
            elements.remove(eleToRemove);
            frequency.remove(eleToRemove);
        }
        elements.put(key, value);
        if (!frequency.containsKey(key)) {
            frequency.put(key, 0);
            LinkedHashSet<Integer> counterSet = counter.getOrDefault(0, new LinkedHashSet<>());
            counterSet.add(key);
            counter.put(0, counterSet);
        } else {
            get(key);
        }
    }
}