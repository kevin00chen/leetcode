package com.ckm.normal;

public class Solution5 {

    /**
     * Manacher算法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String str = expandStr(s);

        int mr = -1;
        int id = -1;
        int[] rad = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int r = 1;
            if (mr >= i) {
                r = Math.min(rad[2 * id - i], rad[id] - (i - id));

                if (r == rad[id] - (i - id)) {
                    while (i - r >= 0
                            && i + r < str.length()
                            && (str.charAt(i + r) == str.charAt(i - r))) {
                        r ++;
                    }
                }
            } else {
                while (i - r >= 0
                        && i + r < str.length()
                        && (str.charAt(i + r) == str.charAt(i - r))) {
                    r ++;
                }
            }

            if (i + r - 1 > mr) {
                mr = i + r - 1;
                id = i;
            }

            rad[i] = r;
        }

        int maxId = 0;
        int maxRad = 1;

        for (int i = 0; i < str.length(); i++) {
            if (rad[i] > maxRad) {
                maxId = i;
                maxRad = rad[i];
            }
        }

        String result = "";
        int startI = Math.max(0, maxId - maxRad + 1);
        int endI = Math.min(str.length(), maxId + maxRad - 1);
        result = originStr(str.substring(startI, endI));

        return result;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }

        boolean f[][]=new boolean[s.length()][s.length()];
        int maxLength = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j, f) && (j - i + 1) > maxLength) {
                    maxLength = j - i;
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int i, int j, boolean[][] f) {
        if (i == j) {
            f[i][j] = true;
            return f[i][j];
        } else if (j == i + 1) {
            f[i][j] = s.charAt(i) == s.charAt(j);
            return f[i][j];
        } else {
            f[i][j] = s.charAt(i) == s.charAt(j) && (f[i + 1][j - 1] || isPalindrome(s, i + 1, j - 1, f));
            return f[i][j];
        }
    }

    private String expandStr(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#");
        return sb.toString();
    }

    private String originStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i += 2) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 中心遍历
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        String result = "";
        int maxLength = 0;
        String str = expandStr(s);
        for (int i = 0; i < str.length(); i ++) {
            int tmpMaxLength = 1;
            int l = i - 1;
            int r = i + 1;

            while (l >= 0 && r < str.length()) {
                if (str.charAt(l) == str.charAt(r)) {
                    l --;
                    r ++;
                    tmpMaxLength += 2;
                } else {
                    break;
                }
            }

            if ((tmpMaxLength - 1) / 2 > maxLength) {
                l = l + 1;
                maxLength = (tmpMaxLength - 1) / 2;
                result = str.substring(l, r);
            }
        }

        return originStr(result);
    }

    /**
     * 暴力解法，反转字符串，求最长公共子序列
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i --) {
            sb.append(s.charAt(i - 1));
        }
        String r = sb.toString();

        sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char sc = s.charAt(i);
            for (int j = 0; j < r.length(); j ++) {
                char rc = r.charAt(j);
            }
        }


        return sb.toString();
    }
}
