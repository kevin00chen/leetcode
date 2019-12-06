package com.ckm.string;

public class Solution44 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] fn = new boolean[m + 1][n + 1];

        // 初始化
        fn[0][0] = true;
        for(int j = 1; j <= n; j++)
            fn[0][j] = p.charAt(j-1) == '*' && fn[0][j-1];

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    fn[i][j] = fn[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    fn[i][j] = fn[i][j - 1] || fn[i - 1][j];
                }
            }
        }

        return fn[m][n];
    }
}
