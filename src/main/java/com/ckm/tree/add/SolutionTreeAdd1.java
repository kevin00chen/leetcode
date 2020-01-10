package com.ckm.tree.add;

import com.ckm.common.TreeNode;

public class SolutionTreeAdd1 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        return 0;
    }


    public void xx(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum += root.val;
        maxSum = Math.max(maxSum, sum);
        xx(root.left, sum);
        xx(root.right, sum);
        sum -= root.val;
    }

}
