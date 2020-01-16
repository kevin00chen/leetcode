package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        if (headA == null || headB == null) {
            return null;
        }

        // Step-1
        while (p.next != null && q.next != null) {
            p = p.next;
            q = q.next;
        }

        // Step-2
        ListNode s = headA;
        ListNode t = p;
        ListNode c = headB;
        if (p.next == null) {
            s = headB;
            c = headA;
            t = q;
        }

        while (t.next != null) {
            t = t.next;
            s = s.next;
        }

        // Step-3
        while (c != s && c != null && s != null) {
            c = c.next;
            s = s.next;
        }

        return c == s ? c : null;
    }
}
