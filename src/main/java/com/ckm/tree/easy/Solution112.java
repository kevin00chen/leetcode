package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return sum(sum, root);
    }

    private boolean sum(int sum, TreeNode root) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        if (root.left == null) {
            return sum(sum - root.val, root.right);
        }

        if (root.right == null) {
            return sum(sum - root.val, root.left);
        }

        boolean lsum = sum(sum - root.val, root.left);
        boolean rsum = sum(sum - root.val, root.right);

        return lsum || rsum;
    }
}
