package com.ckm.sort.easy;

public class Solution1370 {
    public String sortString(String s) {
        // 以字符下标记录字符出现的次数
        int[] cs = new int[26];

        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        // 未处理的字符的长度
        int n = s.length();
        int i = 0;
        int dir = 1;
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            if (i < 0) { // 如果遍历到最小的字符后，那么接下来需要开始升序
                dir = 1;
            } else if (i == cs.length) { // 如果遍历到最大的那个字符了，就表示已经升序完成了，接下来需要降序了
                dir = -1;
            } else if (cs[i] > 0) { // 如果当前字符还有未处理过的，计数减一，未处理字符长度减一，当前字符写入结果中
                cs[i] --;
                n --;
                result.append((char)('a' + i));
            }

            i += dir;
        }

        return result.toString();
    }
}
