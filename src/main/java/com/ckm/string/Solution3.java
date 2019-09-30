package com.ckm.string;
import java.util.HashMap;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s.length() == 1) {
            result = 1;
        } else {
            Map<Character, Integer> charIndex = new HashMap();
            int index = 0;

            int tmpResult = 0;
            int lastCommonChar = 0;

            while (index < s.length()) {
                int tmpIndex = index;
                char currentChar = s.charAt(index);
                if (charIndex.containsKey(currentChar)) {
                    lastCommonChar = charIndex.get(currentChar) > lastCommonChar ? charIndex.get(currentChar) : lastCommonChar;
                    if (tmpResult > result) {
                        result = tmpResult;
                    }
                    tmpResult = index - lastCommonChar;
                } else {
                    tmpResult ++;
                }
                index ++;
                charIndex.put(currentChar, tmpIndex);
            }

            if (tmpResult > result) {
                result = tmpResult;
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
