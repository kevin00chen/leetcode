package com.ckm.sort.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1122 {
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i : arr1) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }

        int[] result = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            int count = cnt.get(i);
            for (int j = 0; j < count; j ++) {
                result[index ++] = i;
            }
            cnt.remove(i);
        }

        Object[] remainKeys = cnt.keySet().toArray();
        Arrays.sort(remainKeys);
        for (Object i :remainKeys) {
            int count = cnt.get(i);
            for (int j = 0; j < count; j ++) {
                result[index ++] = (int) i;
            }
        }

        return result;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 元素长度和元素值不超过1000，所以可以构造一个初始数组，记录每个元素出现的次数，类似于一个bitmap
        int[] bucket = new int[1001];

        int[] result = new int[arr1.length];
        int index = 0;

        // 遍历数组一，计数
        for(int i : arr1) {
            bucket[i]++;
        }

        // 按数组二的顺序，以及出现次数对输出结果数组进行填充
        for(int i : arr2) {
            while(bucket[i]-- > 0) {
                result[index++] = i;
            }
        }

        // 填充其他数字，这里利用了前面那个1001数组的下标排序，这次遍历只需要取出其中值不为0的元素，依次填充即可
        for(int i = 0; i < 1001; i++){
            if(bucket[i] > 0) {
                while(bucket[i]-- > 0) {
                    result[index++] = i;
                }
            }
        }
        return result;
    }
}
