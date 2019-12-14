package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
//        return s2(root);
        return s1(null, root);
    }

    public TreeNode s1(TreeNode node, TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) { // 如果左子树为空，只需要调整右子树的顺序即可
            root.right = s1(root, root.right);
            return root;
        } else { // 如果左子树不为空，首先将左子树排好序，然后将左子树最后节点连接到当前节点上。
            TreeNode left = s1(root, root.left);
            TreeNode right = s1(root, root.right);
            TreeNode tmp = left.right;

            if (tmp == null) {
                tmp = left;
            } else {
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
            }
            tmp.right = root;
            root.left = null;
            root.right = right;
            return left;
        }
    }

    private TreeNode s2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        r(root, list);

        TreeNode result = new TreeNode(list.get(0));
        TreeNode tmp = result;
        for (int i = 1; i < list.size() && tmp != null; i++) {
            tmp.left = null;
            tmp.right = new TreeNode(list.get(i));
            tmp = tmp.right;
        }

        return result;
    }

    private void r(TreeNode root, List<Integer> result) {
        if (root != null) {
            r(root.left, result);
            result.add(root.val);
            r(root.right, result);
        }
    }
}
