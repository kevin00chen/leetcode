package com.ckm.tree;

import com.ckm.common.Node;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        i(root, result);
        return result;
    }

    private void i(Node root, List<Integer> result) {
        Stack<Node> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i --) {
                    stack.add(node.children.get(i));
                }
            }
        }
    }

    private void r(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    r(node, result);
                }
            }
        }
    }


}
