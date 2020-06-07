package com.ckm.sort.medium;

import com.ckm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = inOrderTraverse(root1);
        List<Integer> result2 = inOrderTraverse(root2);

        List<Integer> result = new ArrayList<>();

        int end1 = 0;
        int end2 = 0;

        while (end1 < result1.size() || end2 < result2.size()) {
            if (end2 == result2.size()) {
                for (; end1 < result1.size(); end1 ++) {
                    result.add(result1.get(end1));
                }
            } else {
                while (end1 < result1.size() && result1.get(end1) <= result2.get(end2)) {
                    result.add(result1.get(end1));
                    end1++;
                }
            }

            if (end1 == result1.size()) {
                for (; end2 < result2.size(); end2 ++) {
                    result.add(result2.get(end2));
                }
            } else {
                while (end2 < result2.size() && result2.get(end2) <= result1.get(end1)) {
                    result.add(result2.get(end2));
                    end2++;
                }
            }
        }
        return result;
    }

    private List<Integer> inOrderTraverse(TreeNode node) {
        List<Integer> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

        result.addAll(inOrderTraverse(node.left));
        result.add(node.val);
        result.addAll(inOrderTraverse(node.right));

        return result;
    }
}
