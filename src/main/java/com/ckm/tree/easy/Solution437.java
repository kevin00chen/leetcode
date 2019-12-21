package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return isMeet(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // 计算包含当前根节点的路径中可能路径的条数
    private int isMeet(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return (root.val == sum ? 1 : 0) + isMeet(root.left, sum - root.val) + isMeet(root.right, sum - root.val);
    }
}
