package com.ckm.array;

public class Solution11 {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int i = 0;
        int j = height.length - 1;
        int maxSize = 0;

        while (i < j) {
            int size = (j - i) * Math.min(height[i], height[j]);
            if (size > maxSize) {
                maxSize = size;
            }

            if (height[i] < height[j]) {
                i ++;
            } else {
                j --;
            }
        }

        return maxSize;
    }

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxSize = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int size = (j - i) * h;
                if (size > maxSize) {
                    maxSize = size;
                }
            }
        }

        return maxSize;
    }
}
