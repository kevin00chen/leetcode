package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            subPath(result, "", root);
        }
        return result;
    }

    private void subPath(List<String> result, String path, TreeNode root) {
        String prefix = path.equals("") ? path : path + "->";

        if (root.left == null && root.right == null) {
            result.add(prefix + root.val);
        }

        if (root.left != null) {
            subPath(result, prefix + root.val, root.left);
        }

        if (root.right != null) {
            subPath(result, prefix + root.val, root.right);
        }
    }
}
