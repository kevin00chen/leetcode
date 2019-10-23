package com.ckm.array;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int best = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(best - target);
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i ++) {
            int start = i + 1;
            int end = len - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum > target) {
                    if (sum - target < diff) {
                        best = sum;
                    }
                    end --;
                } else if (sum < target) {
                    if (target - sum < diff) {
                        best = sum;
                    }
                    start ++;
                } else {
                    best = sum;
                    break;
                }
                diff = Math.abs(best - target);
            }
        }
        return best;
    }
}
