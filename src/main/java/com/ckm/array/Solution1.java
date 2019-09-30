package com.ckm.array;
import	java.util.HashMap;

import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            Map<Integer, Integer> values = new HashMap<> ();

            for (int i = 0; i < nums.length; i++) {
                int res = target - nums[i];
                if (values.containsKey(res)) {
                    return new int[]{values.get(res), i};
                } else {
                    values.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
