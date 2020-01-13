package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = head;

        ListNode next = head.next;
        int count = 1;
        while (next != null) {
            if (count == 1) {
                result = result.next;
            }

            if (count++ == 2) {
                count = 1;
            }

            next = next.next;
        }

        return result;
    }

    /**
     * 快指针每次跳两个，慢指针每次跳一个
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
