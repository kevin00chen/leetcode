package com.ckm.other.medium;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] fn = new int[m][n];
        fn[0][0] = grid[0][0];

        for (int i = 1; i < m; i ++) {
            fn[i][0] = fn[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i ++) {
            fn[0][i] = fn[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                fn[i][j] = Math.min(fn[i - 1][j] + grid[i][j], fn[i][j - 1] + grid[i][j]);
            }
        }

        return fn[m - 1][n - 1];
    }
}
