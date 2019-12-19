package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution687 {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = arrowLength(node.left);
        int right = arrowLength(node.right);

        int arrowLeft = 0;
        int arrowRight = 0;

        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }

        // 相同路径可以通过根节点。并且只有根节点值同时等于左子节点值以及右子节点值时才会出现两边都不为0的情况。否则，总有一边为0.
        ans = Math.max(ans, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }
}