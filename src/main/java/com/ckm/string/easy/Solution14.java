package com.ckm.string.easy;

public class Solution14 {

    /**
     * 分治
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String leftResult = longestCommonPrefix(strs, left, mid);
        String rightResult = longestCommonPrefix(strs, mid + 1, right);

        return commonPrefix(leftResult, rightResult);
    }

    private String commonPrefix(String left, String right) {
        String result = left;

        while (right.indexOf(result) != 0) {
            result = result.substring(0, result.length() - 1);
            if (result.isEmpty())
                return "";
        }
        return result;
    }

    /**
     * 遍历查找
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * 暴力匹配
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (!str.isEmpty()) {
                minLength = Math.min(minLength, str.length());
            } else {
                minLength = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean same = true;
        for (int i = 0; i < minLength && same; i++) {
            char common = ' ';
            for(String str : strs) {
                if (common != ' ' && str.charAt(i) != common) {
                    same = false;
                    common = ' ';
                    break;
                } else {
                    common = str.charAt(i);
                }
            }
            if (common != ' ')
                sb.append(common);
        }

        return sb.toString();
    }
}
