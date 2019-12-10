package com.ckm.tree;

import com.ckm.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int depth = 0;
        getData(result, depth, root);
        Collections.reverse(result);
        return result;
    }

    private void getData(List<List<Integer>> list, int depth, TreeNode root) {
        if (root != null) {
            if (list.size() <= depth) {
                list.add(depth, new ArrayList<>());
            }
            getData(list, depth + 1, root.left);
            getData(list, depth + 1, root.right);
            list.get(depth).add(root.val);
        }
    }
}
