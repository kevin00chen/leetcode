package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution563 {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);

        return left + root.val + right;
    }
}
