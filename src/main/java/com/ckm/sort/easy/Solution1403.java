package com.ckm.sort.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        // 记录未取出的元素之和，初始值为0，第一次遍历数组时求和
        int sum = 0;
        // 记录不同数值的元素的个数，从1 ~ 100
        int[] n = new int[101];
        // 遍历元素，计数，求和
        for (int i = 0; i < nums.length; i ++) {
            n[nums[i]] ++;
            sum += nums[i];
        }

        // 子序列的和
        int total = 0;
        // 当前元素所在的位置，初始为最大值即n[100]，表示元素值为100的地方
        int pos = 100;
        while (total <= sum) {
            if (n[pos] > 0) {
                total += pos;
                sum -= pos;
                n[pos] --;
                list.add(pos);
            } else {
                pos --;
            }
        }
        return list;
    }
}
