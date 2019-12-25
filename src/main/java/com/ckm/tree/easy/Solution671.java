package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution671 {
    int min;
    long ans = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null) {
            if (min < root.val && root.val < ans) {
                ans = root.val;
            } else if (min == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}
