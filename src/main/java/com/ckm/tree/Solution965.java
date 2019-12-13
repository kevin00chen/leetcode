package com.ckm.tree;

import com.ckm.common.TreeNode;

public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        boolean result = true;

        if (root.left != null) {
            result &= result & root.val == root.left.val && isUnivalTree(root.left);
        }

        if (root.right != null) {
            result &= result & root.val == root.right.val && isUnivalTree(root.right);
        }

        return result;
    }
}
