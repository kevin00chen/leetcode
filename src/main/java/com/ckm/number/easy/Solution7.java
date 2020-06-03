package com.ckm.number.easy;

public class Solution7 {
    public int reverse(int x) {
        String str = (x + "").replace("-", "");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        try {
            if (x < 0) {
                return Integer.parseInt("-" + sb.toString());
            } else {
                return Integer.parseInt(sb.toString());
            }
        } catch (Exception e) {
            return 0;
        }
    }

}
