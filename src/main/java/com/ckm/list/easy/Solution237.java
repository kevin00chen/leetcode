package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
