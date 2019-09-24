package com.ckm.normal;

public class Solution5 {

    /**
     * 中心遍历
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#");

        String str = sb.toString();
        String result = "";
        int maxLength = 0;

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

        sb = new StringBuilder();
        for (int i = 1; i < result.length(); i += 2) {
            sb.append(result.charAt(i));
        }

        return sb.toString();
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
