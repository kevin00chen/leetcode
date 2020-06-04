package com.ckm.sort.easy;

public class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] nums;
        int[][] result = new int[m][n];

        // 处理行，0 ~ m行
        for (int i = 0; i < m; i ++) {
            nums = new int[101];
            int ti = i;
            int tj = 0;
            while (tj < n && ti < m) {
                nums[mat[ti][tj]] += 1;
                ti ++;
                tj ++;
            }

            ti = i;
            tj = 0;
            int index = 1;
            while (tj < n && ti < m) {
                while (nums[index] == 0) {
                    index ++;
                }
                result[ti][tj] = index;
                ti ++;
                tj ++;
                nums[index] --;
            }
        }

        // 处理列，0 ~ n列
        for (int i = 0; i < n; i ++) {
            nums = new int[101];
            int ti = 0;
            int tj = i;
            while (tj < n && ti < m) {
                nums[mat[ti][tj]] += 1;
                ti ++;
                tj ++;
            }

            ti = 0;
            tj = i;
            int index = 1;
            while (tj < n && ti < m) {
                while (nums[index] == 0) {
                    index ++;
                }
                result[ti][tj] = index;
                ti ++;
                tj ++;
                nums[index] --;
            }
        }
        return result;
    }
}
