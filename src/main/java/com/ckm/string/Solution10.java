package com.ckm.string;

public class Solution10 {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        // 数组dp用来记录s[0, i - 1]是否匹配p[0, j - 1]，所以改数组长度为字符串长度加1
        boolean[][] dp = new boolean[sArr.length + 1][pArr.length + 1];

        // 初始化，两个空字符串可以匹配成功
        dp[0][0] = true;

        // 初始化，空字符串s是否匹配非空字符串p[0, i - 1]，如果pArr[i - 1]为*，那么就看p[0, i - 1]是否和空串s匹配，否则直接不匹配
        for (int i = 1; i <= pArr.length; ++i) {
            dp[0][i] = pArr[i - 1] == '*' ? dp[0][i - 2] : false;
        }

        for (int i = 1; i <= sArr.length; ++i) {
            for (int j = 1; j <= pArr.length; ++j) {
                if (sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '.') {
                    // 如果当前字符相同，或者p当前字符为.，则看dp[i - 1][j - 1]是否匹配
                    dp[i][j] = dp[i - 1][j - 1];
                }

                if (pArr[j - 1] == '*') {
                    // 如果p当前为*，则看dp[i][j - 2]是否匹配
                    dp[i][j] |= dp[i][j - 2];

                    if (pArr[j - 2] == sArr[i - 1] || pArr[j - 2] == '.') {
                        // 看 s[0,...i-1] 和 p[0,...j]
                        // 如果p[j - 2]为.或者p[j - 2]和s[i - 1]相等，则看dp[i - 1][j]是否匹配
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[sArr.length][pArr.length];
    }

    /**
     * 递归
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        // 判断首字符是否相同
        boolean isFirstMatch = false;
        if (!s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            isFirstMatch = true;
        }

        // 如果p中第二个字符为*，则分别计算p(2)是否匹配s以及s(1)是否匹配p
        // p(2)表示p的首字符没有匹配到s时，由于*可以表示0个字符，那么可以直接跳过p的前两个字符
        // s(1)表示s的首字符匹配到了p，接下来判断s(1)是否匹配p即可
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch1(s, p.substring(2)) ||
                    (isFirstMatch && isMatch1(s.substring(1), p));
        }

        // 判断s(1)是否匹配p(1)
        return isFirstMatch && isMatch1(s.substring(1), p.substring(1));
    }
}
