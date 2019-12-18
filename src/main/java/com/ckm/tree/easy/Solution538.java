package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

public class Solution538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        updateNode(null, root);
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }

        return root;
    }

    private void updateNode(TreeNode p, TreeNode c) {
        if (p == null) {
            updateNode(c, c.right);
            if (c.right != null)
                c.val += c.right.val;
            updateNode(c, c.left);
        } else if (c != null) {
            if (c == p.left) {
                if (c.right != null) {
                    updateNode(c, c.right);
                    c.val += c.right.val;
                } else {
                    c.val += p.val;
                }
            } else if (c == p.right) {
                if (c.right != null) {
                    c.val += c.right.val;
                }
            }
        }
    }
}
