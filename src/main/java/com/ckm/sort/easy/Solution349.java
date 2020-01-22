package com.ckm.sort.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i : nums1) {
            s1.add(i);
        }

        for (int i : nums2) {
            s2.add(i);
        }

        int[] result = new int[s1.size()];
        int index = 0;

        for (int i : s1) {
            if (s2.contains(i)) {
                result[index ++] = i;
            }
        }

        return Arrays.copyOf(result, index);
    }
}
