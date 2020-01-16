package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr.next != null) {
            if (ptr.next.val == val) { // 如果下一个元素需要删除，则当前节点指向下下个元素
                ptr.next = ptr.next.next;
            } else { // 否则当前节点移动到下一个元素
                ptr = ptr.next;
            }
        }

        return dummy.next;
    }
}
