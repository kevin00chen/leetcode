package com.ckm.array;

import com.ckm.common.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] tmpResult = digits(l1.val + l2.val);
        ListNode result = new ListNode(tmpResult[1]);
        ListNode index = result;
        int preSum = tmpResult[0];

        ListNode t1 = l1.next;
        ListNode t2 = l2.next;

        while (t1 != null || t2 != null || preSum != 0) {
            int tmpSum = preSum;
            if (t1 != null) {
                tmpSum += t1.val;
                t1 = t1.next;
            }

            if (t2 != null) {
                tmpSum += t2.val;
                t2 = t2.next;
            }

            tmpResult = digits(tmpSum);
            preSum = tmpResult[0];
            index.next = new ListNode(tmpResult[1]);
            index = index.next;
        }

        return result;
    }

    public int[] digits(int num) {
        int d0 = num % 10;
        int d1 = (num - d0) / 10;

        return new int[]{d1, d0};
    }

}