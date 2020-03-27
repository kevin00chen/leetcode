package com.ckm.sort.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums2.length];

        int i = 0;
        for (int num : nums2) {
            if (count.containsKey(num)) {
                if (count.get(num) > 0) {
                    count.put(num, count.get(num) - 1);
                    result[i] = num;
                    i ++;
                } else {
                    count.remove(num);
                }
            }
        }
        return Arrays.copyOf(result, i);
    }
}
