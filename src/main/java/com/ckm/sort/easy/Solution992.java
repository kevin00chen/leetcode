package com.ckm.sort.easy;

public class Solution992 {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null) {
            return null;
        }
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 0) { // 如果该位置上是偶数
                if (A[i + 1] % 2 == 0) { // 如果下一位置为偶数
                    for (int j = i + 2; j < A.length; j += 2) {
                        if (A[j] % 2 == 1) {
                            int tmp = A[i + 1];
                            A[i + 1] = A[j];
                            A[j] = tmp;
                        }
                    }
                }
            } else { // 如果该位置上是奇数
                for (int j = i + 1; j < A.length; j += 2) { // 只需要从当前位置往后看
                    if (A[j] % 2 == 0) {
                        int tmp = A[j];
                        A[j] = A[i];
                        A[i] = tmp;
                    }
                }
            }
        }
        return A;
    }
}
