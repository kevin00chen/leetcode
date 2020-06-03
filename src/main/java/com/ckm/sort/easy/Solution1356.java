package com.ckm.sort.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int result[] = new int[n];
        // 定义一个优先队列，使用1-bits数量排序，如果相等，按照大小排序
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        int w1 = Integer.bitCount(a);
                        int w2 = Integer.bitCount(b);
                        if (w1 == w2) {
                            return a - b;
                        }
                        return w1 - w2;
                    }
                });
        int ind = 0;
        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
        }
        while (minHeap.size() > 0) {
            int num = minHeap.poll();
            result[ind++] = num;
        }
        return result;
    }
}
