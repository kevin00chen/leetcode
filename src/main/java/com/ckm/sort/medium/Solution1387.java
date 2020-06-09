package com.ckm.sort.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1387 {
    Map<Integer, Integer> dp = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        dp.put(1, 0);
        int[][] arr = new int[hi - lo + 1][2]; // 二维数组，每一行分别存数字，以及该数字对应的power值
        for(int i = lo, j = 0;i <= hi; i++, j++){
            int count = getPower(i);
            arr[j][0] = i;  //
            arr[j][1] = count; //
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        return arr[k - 1][0];
    }

    private int getPower(int n) {
        if (dp.getOrDefault(n, -1) >= 0) {
            return dp.get(n);
        }

        if (n % 2 == 0) {
            dp.put(n, getPower(n / 2) + 1);
        } else {
            dp.put(n, getPower(n * 3 + 1) + 1);
        }

        return dp.get(n);
    }
}
