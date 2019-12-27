package com.ckm.tree.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution834 {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] fn = new int[N][N];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            Set<Integer> tmp = map.getOrDefault(edge[0], new HashSet<>());
            tmp.add(edge[1]);
            map.put(edge[0], tmp);

            fn[edge[0]][edge[1]] = 1;
        }

        for (int i = N - 1; i > 0; i --) {
            for (int j = i - 1; j >= 0; j --) {
                boolean needToAdd = true;
                for (int m = j + 1; m <= i; m ++) {
                    needToAdd &= map.getOrDefault(j, new HashSet<>()).contains(m);
                    fn[j][i] += fn[m - 1][m];
                }

                if (!needToAdd) {
                    fn[j][i] = 0;
                }

                System.out.println();
            }
        }

        return null;
    }
}
