package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && slow != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return fast == slow;
    }
}
