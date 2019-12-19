package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution501 {
    List<Integer> modes = new ArrayList<>();
    int count = 0;
    int max = 0;
    Integer pre = null;

    public int[] findMode(TreeNode root) {
        inOrder(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);

            if (pre == null) {
                count = 1;
            } else {
                if (pre == root.val) {
                    count ++;
                } else {
                    count = 1;
                }
            }

            if (count > max) {
                modes.clear();
                modes.add(root.val);
                max = count;
            } else if (count == max) {
                modes.add(root.val);
            }

            pre = root.val;
            inOrder(root.right);
        }
    }
}
