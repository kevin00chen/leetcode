package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution1022 {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    public int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = (sum * 2) + root.val;
        if ((root.left == null) && (root.right == null))
            return sum;
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }
}
