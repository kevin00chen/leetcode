package com.ckm.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        if (len < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i ++) {
            int start = i + 1;
            int end = len - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum > 0) {
                    end --;
                } else if (sum < 0) {
                    start ++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    result.add(tmp);

                    start ++;
                    end --;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start ++;
                    }

                    while (start < end && nums[end] == nums[end + 1]) {
                        end --;
                    }
                }
            }
        }

        return result;
    }
}
