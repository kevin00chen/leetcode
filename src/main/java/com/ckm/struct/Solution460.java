package com.ckm.struct;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 按使用频率缓存
 */
public class Solution460 {
    int capacity;
    Map<Integer, Integer> elements;
    Map<Integer, Integer> frequency;
    Map<Integer, TreeSet<Integer>> useTimeToEles;
    int leastUseTime;

    public Solution460(int capacity) {
        this.capacity = capacity;
        this.elements = new HashMap<>();
        this.frequency = new HashMap<>();
        this.useTimeToEles = new HashMap<>();
        leastUseTime = 0;
    }

    public int get(int key) {
        if (elements.containsKey(key)) {
            useTimeToEles.get(frequency.get(key)).remove(key);
            frequency.put(key, frequency.get(key) + 1);
        }

        TreeSet<Integer> treeSet = useTimeToEles.getOrDefault(frequency.get(key), new TreeSet<>());
        treeSet.add(key);
        useTimeToEles.put(frequency.get(key), treeSet);

        if (frequency.containsKey(key) && frequency.get(key) < leastUseTime) {
            leastUseTime = frequency.get(key);
        }

        return elements.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (elements.size() >= capacity) {
            TreeSet<Integer> t = useTimeToEles.get(leastUseTime);

            if (t.size() <= 0) {
                useTimeToEles.remove(leastUseTime);
                int tmp = Integer.MAX_VALUE;

                Set<Integer> keys = useTimeToEles.keySet();
                for (Integer k : keys) {
                    if (k != null && useTimeToEles.get(k).size() > 0) {
                        if (k < tmp) {
                            tmp = k;
                        }
                    } else {
//                        useTimeToEles.remove(k);
                    }
                }
                leastUseTime = tmp;
            }

            t = useTimeToEles.get(leastUseTime);
            int eleToRemove = t.pollFirst();
            elements.remove(eleToRemove);
            frequency.remove(eleToRemove);
        }
        elements.put(key, value);
        frequency.put(key, 0);
        leastUseTime = 0;
        TreeSet<Integer> treeSet = useTimeToEles.getOrDefault(0, new TreeSet<>());
        treeSet.add(key);
        useTimeToEles.put(0, treeSet);
    }
}