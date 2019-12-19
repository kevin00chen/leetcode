package com.ckm.tree.easy;


import com.ckm.common.TreeNode;

public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        return minDiff(root, Integer.MAX_VALUE);
    }

    private int minDiff(TreeNode root, int diff) {
        if (root == null) {
            return diff;
        }

        if (root.left == null && root.right == null) {
            return diff;
        }

        int rightMin = Integer.MAX_VALUE;
        if (root.right != null) {
            TreeNode node = root.right;
            while(node.left != null) {
                node = node.left;
            }

            rightMin = Math.min(Math.min(node.val - root.val, diff), minDiff(root.right, diff));
        }

        int leftMin = Integer.MAX_VALUE;
        if (root.left != null) {
            TreeNode node = root.left;
            while(node.right != null) {
                node = node.right;
            }
            leftMin = Math.min(Math.min(root.val - node.val, diff), minDiff(root.left, diff));
        }

        return Math.min(rightMin, leftMin);
    }
}
