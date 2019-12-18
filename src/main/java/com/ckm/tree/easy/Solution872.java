package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }


    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
            }

            dfs(root.left, leaves);
            dfs(root.right, leaves);
        }
    }

}
