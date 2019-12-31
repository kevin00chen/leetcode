package com.ckm.tree.hard;

import java.util.*;

public class Solution834 {
    Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
    Map<Integer, List<int[]>> edgeCan = new HashMap<>();
    Set<Integer> notLeaf = new HashSet<>();
    int[][] fn;
    int[] ans;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N <= 1) {
            return new int[N];
        }

        fillEdgeCan(edges);
        adjustEdges(edgeCan.get(0), 0);

        int root = 0;
        fn = init(N);
        fillFN(root);

        ans = new int[N];
        ans[root] = fn[root][0];
        getResult(root, N);

        return ans;
    }

    /**
     * 调整每个节点需要遍历的边数，不管顺序，只要包含就作为候选目标。如果不加这段逻辑，那么每一个节点都是遍历N-1条边。
     * @param edges
     */
    private void fillEdgeCan(int[][] edges) {
        for (int[] edge : edges) {
            List<int[]> list1 = edgeCan.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge);
            edgeCan.put(edge[0], list1);

            List<int[]> list2 = edgeCan.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge);
            edgeCan.put(edge[1], list2);
        }
    }

    /**
     * 调整连接顺序，以0为根节点，并且从上往下连接
     * @param edges
     * @return
     */
    private void adjustEdges(List<int[]> edges, int root) {
        for (int[] edge : edges) {
            if (!edgeMap.getOrDefault(edge[0], new HashSet<>()).contains(edge[1])
                    && !edgeMap.getOrDefault(edge[1], new HashSet<>()).contains(edge[0])) {
                if (edge[1] == root || edge[0] == root) {
                    if (edge[1] == root) {
                        edge[1] = edge[0];
                        edge[0] = root;
                    }
                    Set<Integer> tmp = edgeMap.getOrDefault(edge[0], new HashSet<>());
                    tmp.add(edge[1]);
                    edgeMap.put(edge[0], tmp);
                    adjustEdges(edgeCan.get(edge[1]), edge[1]);
                }
            }
        }
    }

    /**
     * 由递推公式计算各节点的ans，从root节点开始
     * @param root
     * @return
     */
    private void getResult(int root, int N) {
        Set<Integer> child = edgeMap.getOrDefault(root, new HashSet<>());

        for (int i : child) {
            ans[i] = ans[root] - 2 * fn[i][1] + N;
            getResult(i, N);
        }
    }

    /**
     * @param root 当前节点
     * @return
     */
    private int[] fillFN(int root) {
        int tmp = 0;
        Set<Integer> child = edgeMap.getOrDefault(root, new HashSet<>());

        for (int i : child) {
            int[] tmpResult = fn[i];
            if (notLeaf.contains(i)) {
                tmpResult = fillFN(i);
            }
            fn[root][0] += tmpResult[0] + tmpResult[1];
            tmp += tmpResult[1];
        }

        if (notLeaf.contains(root)) {
            fn[root][1] += tmp == 0 ? 0 : (tmp + 1);
        }
        return fn[root];
    }

    /**
     * 对fn，初始化所有叶子节点
     */
    private int[][] init(int N) {
        fn = new int[N][2];

        notLeaf = edgeMap.keySet();

        for (int i = 0; i < N; i ++) {
            if (!notLeaf.contains(i)) {
                fn[i][1] = 1;
            }
        }

        return fn;
    }
}
