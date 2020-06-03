package com.ckm.other.medium;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        // fn[i, j] 为当前到点(i, j)所有可能的情况。
        int[][] fn = new int[m][n];

        for (int i = 0; i < m; i ++) {
            fn[i][0] = 1;
        }

        for (int i = 0; i < n; i ++) {
            fn[0][i] = 1;
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                fn[i][j] = fn[i - 1][j] + fn[i][j - 1];
            }
        }
        return fn[m - 1][n - 1];
    }
}
