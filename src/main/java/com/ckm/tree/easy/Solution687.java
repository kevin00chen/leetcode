package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution687 {
    int count = 0;
    int max = 0;
    Integer pre = null;

    public int longestUnivaluePath(TreeNode root) {
        inOrder(root);
        return max > 1 ? max - 1 : 0;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);

            if (pre == null) {
                count = 1;
            } else {
                if (root.val == pre) {
                    count ++;
                } else {
                    count = 1;
                }
            }

            if (count > max) {
                max = count;
            }

            pre = root.val;
            inOrder(root.right);
        }
    }
}
