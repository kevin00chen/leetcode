package com.ckm.string.hard;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        // fn[i][j] 表示长度为i的字符串转换为长度为j的字符串需要的操作次数
        // 递推关系为：fn[m][n] =
        int m = word1.length();
        int n = word2.length();
        int[][] fn = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i ++) {
            fn[0][i] = i;
        }

        for (int i = 1; i <= m; i ++) {
            fn[i][0] = i;
        }


        for (int i = 1; i <=m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    fn[i][j] = fn[i - 1][j - 1];
                } else {
                    fn[i][j] = Math.min(Math.min(fn[i - 1][j - 1], fn[i - 1][j]), fn[i][j - 1]) + 1;
                }
            }
        }

        return fn[m][n];
    }
}
