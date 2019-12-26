package com.ckm.tree.hard;

import com.ckm.common.TreeNode;

public class Solution1028 {

    public TreeNode recoverFromPreorder(String S) {
        if (S.charAt(0) == '-') { // 如果当前字符不是数字，并且root没有初始化
            return null;
        }
        return subTreeNode(S, 0);
    }


    private TreeNode subTreeNode(String S, int depth) {
        TreeNode root;

        if (S.indexOf('-') == -1) {
            if (S.equals("")) {
                root = null;
            } else {
                root = new TreeNode(Integer.parseInt(S));
            }
        } else {
            String rootVal = S.substring(0, S.indexOf('-'));
            root = new TreeNode(Integer.parseInt(rootVal));

            String subS = S.substring(S.indexOf('-') + (++ depth));
            String leftSubS = subS;
            String rightSubS = "";

            for (int i = depth; i < subS.length() - 1; i++) {
                if (subS.charAt(i - depth) != '-' && subS.charAt(i + 1) != '-' && subS.charAt(i) == '-') {
                    leftSubS = subS.substring(0, i - depth + 1);
                    rightSubS = subS.substring(i + 1);
                    break;
                }
            }

            root.left = subTreeNode(leftSubS, depth);
            root.right = subTreeNode(rightSubS, depth);
        }

        return root;
    }
}
