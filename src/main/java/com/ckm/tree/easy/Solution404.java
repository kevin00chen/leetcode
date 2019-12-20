package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            updateSum(root.left, true);
            updateSum(root.right, false);
        }
        return sum;
    }

    private void updateSum(TreeNode root, boolean isLeft) {
        if (root != null) {
            if (root.left == null && root.right == null && isLeft) {
                sum += root.val;
            }
            updateSum(root.right, false);
            updateSum(root.left, true);
        }
    }

}
