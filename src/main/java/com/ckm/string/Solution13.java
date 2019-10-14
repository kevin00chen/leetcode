package com.ckm.string;
import java.util.*;

public class Solution13 {
    public int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer> ();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        Map<Character, String> tags = new HashMap();
        tags.put('I', "VX");
        tags.put('X', "LC");
        tags.put('C', "DM");

        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && tags.keySet().contains(s.charAt(i))) {
                if (tags.get(s.charAt(i)).indexOf(s.charAt(i + 1)) >= 0) {
                    result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i += 2;
                } else {
                    result += map.get(s.charAt(i ++));
                }
            } else {
                result += map.get(s.charAt(i ++));
            }
        }
        return result;
    }
}
