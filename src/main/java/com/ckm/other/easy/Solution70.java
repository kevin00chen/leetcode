package com.ckm.other.easy;

public class Solution70 {

    public int climbStairs(int n) {
        int[] fn = new int[n + 1];
        fn[0] = 0;
        fn[1] = 1;
        if (n >= 2) {
            fn[2] = 2;
        }

        for (int i = 2; i <= n; i ++) {
            fn[i] = fn[i - 1] + fn[i - 2];
        }
        return fn[n];
    }


    /**
     * 递归解法比较耗时
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n <= 2) {
            return n;
        }

        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }
}
