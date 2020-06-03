package com.ckm.string.hard;

public class Solution32 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int fn[] = new int[s.length()];
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    fn[i] = (i - 2 >= 0 ? fn[i - 2] : 0) + 2; // 以()结尾的字符串长度为fn[i - 2] + 2
                } else if (i - fn[i - 1] > 0 && s.charAt(i - fn[i - 1] - 1) == '(') {
                    fn[i] = fn[i - 1] + (i - fn[i - 1] - 2 >= 0 ? fn[i - fn[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, fn[i]);
            }
        }
        return maxans;
    }
}
