package com.ckm.list.easy;

import com.ckm.common.ListNode;

// 1,2,3,4,5
public class Solution206 {
    /**
     * 循环
     * 使用两个指针，每次向后移动，当right到null时停止
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode left = null;
        ListNode right = head;

        while (right != null) {
            ListNode next = right.next;
            right.next = left;

            left = right;
            right = next;
        }

        head = left;
        return head;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    // 1,2,3,4,5
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }

        // 返回除去当前节点后剩下链表的反转结果，返回的是反转结果的头部
        ListNode node = process(head);
        head.next = null;
        return node;
    }

    private ListNode process(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode next = head.next;

        // 最后一个节点
        if (next == null) {
            return head;
        }

        ListNode tmp = process(next);
        next.next = head;

        return tmp;
    }
}
