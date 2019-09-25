package com.ckm.normal;

public class Solution6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        int nPerGroup = numRows * 2 - 2;
        int lPerGroup = numRows - 1;
        int numLines = (int) Math.ceil((s.length() + 0.0) / nPerGroup) * lPerGroup;
        char[][] chars = new char[numRows][numLines];

        int cGroup = 0;
        int rIndex = 0;
        int lIndex = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (i - cGroup * nPerGroup < numRows) {
                chars[rIndex ++][lIndex] = s.charAt(i);
                if (numRows == 2 && i - cGroup * nPerGroup == 1) {
                    cGroup ++;
                    lIndex ++;
                    rIndex = 0;
                }
            } else {
                chars[-- rIndex - 1][++ lIndex] = s.charAt(i);
                if (lIndex == lPerGroup * (cGroup + 1) - 1) {
                    cGroup ++;
                    lIndex ++;
                    rIndex = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numLines; j++) {
                if (chars[i][j] != '\u0000') {
                    sb.append(chars[i][j]);
                }
            }
        }

        return sb.toString();
    }
}
