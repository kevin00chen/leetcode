package com.ckm.list.easy;

import com.ckm.common.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // fast指向倒数第二个节点，slow指向fast的一半处。
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6，fast = 5, slow = 3
        // 1 -> 2 -> 3 -> 4 -> 5，     fast = 5, slow = 3
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 从一半处开始反转后续链表
        ListNode tail = slow.next;
        ListNode next = slow.next.next;

        while (next != null){
            ListNode temp = slow.next;
            slow.next = next;
            tail.next = next.next;
            next.next = temp;
            next = tail.next;
        }

        // 此时slow指向反转后的链表尾部，头尾同时位移
        while (slow.next != null){
            if(head.val != slow.next.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }
}
