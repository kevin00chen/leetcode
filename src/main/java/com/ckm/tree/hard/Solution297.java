package com.ckm.tree.hard;

import com.ckm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        String result = "";

        while (!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.remove();
            String currStr = "null";
            if (curr != null) {
                currStr = curr.val + "";
                nodeQueue.add(curr.left);
                nodeQueue.add(curr.right);
            }
            result += currStr + ",";
        }

        while (result.lastIndexOf("null,") != -1 && result.lastIndexOf("null,") + "null,".length() == result.length()) {
            result = result.substring(0, result.lastIndexOf("null,"));
        }

        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] parts = data.split(",");
        String item = parts[0].trim();
        if ("null".equals(item)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode tmp = nodeQueue.remove();

            if (parts.length == index) {
                break;
            }

            item = parts[index++].trim();
            if (!"null".equals(item)) {
                tmp.left = new TreeNode(Integer.parseInt(item));
                nodeQueue.add(tmp.left);
            }

            if (parts.length == index) {
                break;
            }

            item = parts[index++].trim();
            if (!"null".equals(item)) {
                tmp.right = new TreeNode(Integer.parseInt(item));
                nodeQueue.add(tmp.right);
            }

        }

        return root;
    }
}