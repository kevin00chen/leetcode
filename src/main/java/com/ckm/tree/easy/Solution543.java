package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        pathLength(root);
        return ans;
    }

    private int pathLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = pathLength(root.left) + 1;
        int rightLength = pathLength(root.right) + 1;

        ans = Math.max(ans, leftLength + rightLength - 2);

        return Math.max(leftLength, rightLength);
    }
}
