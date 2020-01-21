package com.ckm.sort.easy;

public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        result[0] = new int[]{r0, c0};

        int maxDis = Math.max(
                Math.max((r0 - 0) + (c0 - 0), (R - r0) + (c0 - 0 - 1)),  // 左上, 左下
                Math.max((r0 - 0) + (C - 1 - c0), (R - 1 - r0) + (C - 1 - c0)) // 右上， 右下
        );

        int index = 1;
        for (int dis = 1; dis <= maxDis; dis ++) {
            for (int rd = 0; rd <= dis; rd ++) {
                int cd = dis - rd;

                if (rd > 0 && cd > 0) {
                    if (r0 - rd >= 0 && c0 - cd >= 0) {
                        result[index ++] = new int[]{r0 - rd, c0 - cd};
                    }

                    if (r0 - rd >= 0 && c0 + cd < C) {
                        result[index ++] = new int[]{r0 - rd, c0 + cd};
                    }

                    if (r0 + rd < R && c0 - cd >= 0) {
                        result[index ++] = new int[]{r0 + rd, c0 - cd};
                    }

                    if (r0 + rd < R && c0 + cd < C) {
                        result[index ++] = new int[]{r0 + rd, c0 + cd};
                    }
                } else if (rd == 0) {
                    if (c0 - cd >= 0) {
                        result[index ++] = new int[]{r0, c0 - cd};
                    }
                    if (c0 + cd < C) {
                        result[index ++] = new int[]{r0, c0 + cd};
                    }
                } else {
                    if (r0 - rd >= 0) {
                        result[index ++] = new int[]{r0 - rd, c0};
                    }
                    if (r0 + rd < R) {
                        result[index ++] = new int[]{r0 + rd, c0};
                    }
                }
            }
        }

        return result;
    }
}
