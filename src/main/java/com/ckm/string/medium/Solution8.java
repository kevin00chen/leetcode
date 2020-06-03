package com.ckm.string.medium;

public class Solution8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }

        if (i == str.length()) {
            return 0;
        }

        if ((str.charAt(i) != '+' && str.charAt(i) != '-') && (str.charAt(i) > '9' || str.charAt(i) < '0')) {
            return 0;
        }

        char tag = ' ';
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            tag = str.charAt(i);
            i ++;
        }

        for (; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                break;
            }
        }

        int j = i;
        for (; j < str.length(); j ++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
        }

        String numStr = str.substring(i, j);
        if (i == j) {
            return 0;
        }

        if (j - i > (Integer.MAX_VALUE + "").length() + 1) {
            if (tag == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        long num = Long.parseLong(numStr) * (tag == '-' ? -1 : 1);
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) num;
        }
    }
}
