package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return bstTreeSearch(root, val);
    }

    private TreeNode bstTreeSearch(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        }

        if (val > root.val) {
            return bstTreeSearch(root.right, val);
        } else {
            return bstTreeSearch(root.left, val);
        }
    }
}
