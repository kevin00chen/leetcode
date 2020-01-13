package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode curr = result;
        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                curr.next = c1;
                c1 = c1.next;
            } else {
                curr.next = c2;
                c2 = c2.next;
            }
            curr = curr.next;
        }

        if (c1 == null) {
            curr.next = c2;
        }

        if (c2 == null) {
            curr.next = c1;
        }

        return result.next;
    }
}
