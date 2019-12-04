package com.ckm.other;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // fn[i, j] 为当前到点(i, j)所有可能的情况。
        int[][] fn = new int[m][n];

        for (int i = 0; i < m; i ++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            fn[i][0] = 1;
        }

        for (int i = 0; i < n; i ++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            fn[0][i] = 1;
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 0) {
                    fn[i][j] = fn[i - 1][j] + fn[i][j - 1];
                }
            }
        }
        return fn[m - 1][n - 1];
    }
}
