package com.ckm.array;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        // 长度为n的数组其最大连续子数组和
        int[] fn = new int[nums.length];
        fn[0] = nums[0];

        int max = fn[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i - 1] > 0) {
                fn[i] = Math.max(fn[i - 1] + nums[i], nums[i]);
                if (fn[i] > max) {
                    max = fn[i];
                }
            }
        }
        return max;
    }
}