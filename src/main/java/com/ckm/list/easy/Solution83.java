package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        int common = head.val - 1;
        ListNode curr = head;
        ListNode next = head;

        while (next != null) {
            if (next.val != common) {
                common = next.val;
                if (curr != next) {
                    curr.next = next;
                    curr = next;
                }
            }
            next = next.next;
        }

        curr.next = null;
        return head;
    }
}
