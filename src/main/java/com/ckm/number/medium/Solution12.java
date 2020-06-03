package com.ckm.number.medium;
import	java.util.HashMap;

import java.util.Map;

public class Solution12 {
    public String intToRoman(int num) { // 1994
        StringBuilder result = new StringBuilder();

        Map<Integer, String> map = new HashMap<Integer, String> ();
        map.put(1000, "M");
        map.put(100, "C");
        map.put(10, "X");
        map.put(1, "I");

        Map<Integer, String> map2 = new HashMap<Integer, String> ();
        map2.put(100, "D");
        map2.put(10, "L");
        map2.put(1, "V");

        int[] order = new int[]{1000, 100, 10, 1};

        for (int i = 0; i < order.length; i++) {
            int n = num / order[i];
            num = num % order[i];
            if (n == 9) {
                result.append(map.get(order[i])).append(map.get(order[i - 1]));
            } else if (n >= 5) {
                result.append(map2.get(order[i])).append(new String(new char[n - 5]).replace("\0", map.get(order[i])));
            } else if (n == 4) {
                result.append(map.get(order[i])).append(map2.get(order[i]));
            } else {
                result.append(new String(new char[n]).replace("\0", map.get(order[i])));
            }
        }

        return result.toString();
    }
}
