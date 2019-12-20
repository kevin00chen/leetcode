package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        return nodeDepth(root, x, 0) == nodeDepth(root, y, 0) && !sameParent(root, x, y);
    }

    private int nodeDepth(TreeNode root, int x, int dep) {
        if (root == null) {
            return 0;
        }

        if (root.val == x) {
            return dep;
        }

        return nodeDepth(root.left, x, dep + 1) + nodeDepth(root.right, x, dep + 1);

    }

    private boolean sameParent(TreeNode root, int x, int y) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val == x) {
            return root.right != null && root.right.val == y;
        }

        if (root.right != null && root.right.val == x) {
            return root.left != null && root.left.val == y;
        }

        return sameParent(root.left, x, y) && sameParent(root.right, x, y);
    }
}
