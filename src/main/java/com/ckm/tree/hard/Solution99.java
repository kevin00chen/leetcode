package com.ckm.tree.hard;

import com.ckm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution99 {

    public void recoverTree(TreeNode root) {
        List<TreeNode> orderList = new ArrayList<>();
        inorder(root, orderList);
    }

    private void inorder(TreeNode root, List<TreeNode> orderList) {
        if(root == null) {
            return;
        }

        inorder(root.left, orderList);

        orderList.add(root);
        int rootIndex = orderList.size() - 1; // List中最后一个节点
        int lastIndex = rootIndex - 1; // List中倒数第二个节点

        // 如果List中有超过两个节点，并且倒数第二个节点的值大于最后一个节点的值，则循环，直接更换这两个节点的值
        while (lastIndex >= 0 && orderList.get(lastIndex).val > orderList.get(rootIndex).val) {
            TreeNode r = orderList.get(rootIndex);
            TreeNode l = orderList.get(lastIndex);
            int data = r.val;
            r.val = l.val;
            l.val = data;

            rootIndex --;
            lastIndex --;
        }

        inorder(root.right, orderList);
    }
}



