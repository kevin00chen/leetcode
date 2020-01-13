package com.ckm.list.normal;

import com.ckm.common.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode start = head;
        ListNode end = head;

        // 如果当前遍历的元素少于需要移除的数字则一直遍历，扩大该窗口的end
        while (size++ < n) {
            end = end.next;
            if (size == n && end == null) {
                return head.next;
            }
            if (end == null) {
                return null;
            }
        }

        while (end.next != null) {
            end = end.next;
            if (size == n + 1) {
                start = start.next;
            } else {
                size ++;
            }
        }

        start.next = start.next.next;

        return head;
    }
}
