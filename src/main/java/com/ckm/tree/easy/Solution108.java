package com.ckm.tree.easy;

import com.ckm.common.TreeNode;

import java.util.Arrays;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int mid = nums.length / 2;
        int[] leftNums = mid > 0 ? Arrays.copyOfRange(nums, 0, mid) : null;
        int[] rightNums = mid + 1 < nums.length ? Arrays.copyOfRange(nums, mid + 1, nums.length) : null;

        TreeNode root = new TreeNode(nums[mid]); // 取中间一个元素
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);

        return root;
    }
}
