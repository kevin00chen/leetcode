package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        return preOrder(t);
    }

    private String preOrder(TreeNode t) {
        if (t == null) {
            return "()";
        }

        if (t.left == null && t.right == null) {
            return t.val + "";
        } else if (t.left == null && t.right != null) {
            return t.val + "()(" + preOrder(t.right) + ")";
        } else if (t.left != null && t.right == null) {
            return t.val + "(" + preOrder(t.left) + ")";
        } else {
            return t.val + "(" + preOrder(t.left) + ")(" + preOrder(t.right) + ")";
        }
    }
}
