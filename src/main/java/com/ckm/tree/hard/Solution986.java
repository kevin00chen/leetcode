package com.ckm.tree.hard;

import com.ckm.common.TreeNode;

public class Solution986 {
    public int minCameraCover(TreeNode root) {
        int[] ans = solve(root); // State-0不满足root节点，所以结果从State-1和State-2中选取最小
        return Math.min(ans[1], ans[2]);
    }

    public int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 99999};
        }

        int[] solveL = solve(root.left);
        int[] solveR = solve(root.right);

        int minL12 = Math.min(solveL[1], solveL[2]);
        int minR12 = Math.min(solveR[1], solveR[2]);

        // State-0，当前节点的左右子节点为State-1，将左右子树全部State-1下的camera相加
        int d0 = solveL[1] + solveR[1];
        // State-1，当前节点的左右子树只能为State-1或State-2，并且必须有一个State-2。下面分别计算左为State-2和右为State-2的情况
        int d1 = Math.min(solveL[2] + minR12, solveR[2] + minL12);
        // State-2，当前节点的左右子树可以为任意状态，如果为State-2，那么当前节点需要有一个"camera"，然后分别计算左右子树中的"camera"数
        int d2 = 1 + Math.min(solveL[0], minL12) + Math.min(solveR[0], minR12);

        return new int[]{d0, d1, d2};
    }
}
