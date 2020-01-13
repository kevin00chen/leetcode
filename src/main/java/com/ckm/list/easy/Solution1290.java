package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        int result = 0;

        if (head == null) {
            return result;
        }

        ListNode next = head;
        while (next != null) {
            result = result * 2 + next.val;
            next = next.next;
        }

        return result;
    }
}
