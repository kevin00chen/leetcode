package com.ckm.array;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 + length2 == 0) {
            return 0;
        } else if (length1 == 0) {
            int index1 = (int) Math.floor(length2 / 2.0);
            int index2 = (int) Math.ceil(length2 / 2.0);
            if (length2 % 2 == 0) {
                index1 --;
            } else {
                index2 = index1;
            }
            return (nums2[index1] + nums2[index2]) / 2.0;
        } else if (length2 == 0) {
            int index1 = (int) Math.floor(length1 / 2.0);
            int index2 = (int) Math.ceil(length1 / 2.0);
            if (length1 % 2 == 0) {
                index1 --;
            } else {
                index2 = index1;
            }
            return (nums1[index1] + nums1[index2]) / 2.0;
        }

        int minIndex = (int) Math.floor((length1 + length2) / 2.0);
        int maxIndex = (int) Math.ceil((length1 + length2) / 2.0);

        int w1 = 0;
        int w2 = 0;
        int r1 = nums1[w1];
        int r2 = nums2[w2];
        while (w1 + w2 < minIndex) {
            if (w1 < length1 - 1 && w2 < length2 - 1) {
                if (r1 <= r2) {
                    r1 = nums1[++w1];
                } else {
                    r2 = nums2[++w2];
                }
            } else if (w1 == length1 - 1) {
                if (w1 + w2 >= minIndex) {
                    r2 = nums2[(length1 + length2) / 2 - length1];
                    if ((length1 + length2) % 2 == 0) {
                        r1 = nums2[(length1 + length2) / 2 - length1 - 1];
                    } else {
                        r1 = r2;
                    }
                }
                w2 ++;
                r2 = nums2[w2];
            } else if (w2 == length2 - 1) {
                if (w1 + w2 >= minIndex) {
                    r1 = nums1[(length1 + length2) / 2 - length2];
                    if ((length1 + length2) % 2 == 0) {
                        r2 = nums1[(length1 + length2) / 2 - length2 - 1];
                    } else {
                        r2 = r1;
                    }
                }
                w1 ++;
                r1 = nums1[w1];
            }
        }

        if (minIndex == maxIndex) {
            return (r1 + r2) / 2.0;
        } else {
            return r1 > r2 ? r2 : r1;
        }
    }
}
