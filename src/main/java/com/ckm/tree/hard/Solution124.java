package com.ckm.tree.hard;

import com.ckm.common.TreeNode;

public class Solution124 {
    public int maxPathSum(TreeNode root) {
        return xx(root)[0];
    }

    /**
     * 对每个节点返回一个二维数组
     * result[0]表示，当前树中的最大路径和
     * result[1]表示，从当前节点出发的最大路径和
     * @param root
     * @return
     */
    public int[] xx(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }

        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val};
        }

        int[] left = xx(root.left);
        int[] right = xx(root.right);

        int mp = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + root.val);
        int mr = Math.max(root.val + left[1], root.val + right[1]);

        return new int[]{mp, mr};
    }
}


//        Input: [1,2,3]
//         1
//        / \
//       2   3
//
//      Output: 6
//
//        Input: [-10,9,20,null,null,15,7]
//        -10
//        / \
//       9  20
//      /     \
//     15      7
//
//     Output: 42