package com.ckm.tree;

import com.ckm.common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            i(root, result);
        }
        return result;
    }

    private void i(Node root, List<Integer> result) {
        Stack<Node> s = new Stack();
        if (root != null) {
            s.push(root);
        }

        while (!s.isEmpty()) {
            Node node = s.pop();
            result.add(node.val);
            if (node.children != null) {
                for (Node n : node.children) {
                    s.push(n);
                }
            }
        }

        Collections.reverse(result);
    }


    private void r(Node root, List<Integer> result) {
        if (root != null) {
            for (Node node : root.children) {
                r(node, result);
            }
            result.add(root.val);
        }
    }
}
