package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution783 {
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null) {
            TreeNode tmp= root.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }

            min = Math.min(Math.min(min, minDiffInBST(root.left)), root.val - tmp.val);
        }

        if (root.right != null) {
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            min = Math.min(Math.min(min, minDiffInBST(root.right)), tmp.val - root.val);
        }

        return min;
    }
}
