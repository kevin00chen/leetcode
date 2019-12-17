package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            root.left = null;
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            root.right = null;
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}
