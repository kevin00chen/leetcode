package com.ckm.tree;

import com.ckm.common.TreeNode;

import java.util.List;

public class Solution111 {
    public int minDepth(TreeNode root) {
        return minDepth(0, root);
    }

    private int minDepth(int depth, TreeNode root) {
        if (root == null) {
            return depth;
        } else {
            int l = minDepth(depth + 1, root.left);
            int r = minDepth(depth + 1, root.right);

            if (root.left == null) {
                return r;
            } else if (root.right == null) {
                return l;
            } else {
                return l > r ? r : l;
            }
        }
    }
}
