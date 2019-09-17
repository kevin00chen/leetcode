package com.ckm.normal;


import com.ckm.common.ListNode;

public class SolutionTest {

    public static void main(String[] args) {
        testSolution3();
    }

    private static void testSolution3() {
        Solution3 solution = new Solution3();
        int s = solution.lengthOfLongestSubstring2("abcdddcbae");
        System.out.println();
    }

    private static void testSolution1() {
        Solution1 solution = new Solution1();
        int[] s = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println();
    }

    private static void testSolution2() {
        Solution2 solution = new Solution2();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        ListNode s = solution.addTwoNumbers(l1, l2);
        System.out.println();
    }
}
