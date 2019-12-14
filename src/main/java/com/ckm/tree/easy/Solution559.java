package com.ckm.tree.easy;

import com.ckm.common.Node;

public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int result = 0;

            if (root.children != null) {
                for (Node node : root.children) {
                    result = Math.max(result, maxDepth(node));
                }
                result += 1;
            }
            return result;
        }
    }
}
