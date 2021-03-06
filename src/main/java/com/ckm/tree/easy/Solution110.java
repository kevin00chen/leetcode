package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = maxDepth(1, root.left);
        int r = maxDepth(1, root.right);

        if (Math.abs(l - r) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }


    private int maxDepth(int depth, TreeNode root) {
        if (root == null) {
            return depth;
        } else {
            int l = maxDepth(depth + 1, root.left);
            int r = maxDepth(depth + 1, root.right);

            if (root.left == null) {
                return r;
            } else if (root.right == null) {
                return l;
            } else {
                return l > r ? l : r;
            }
        }
    }
}
