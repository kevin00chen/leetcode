package com.ckm.normal;


import com.ckm.common.ListNode;

public class SolutionTest {

    public static void main(String[] args) {
        testSolution6();
    }

    private static void testSolution6() {
        Solution6 solution = new Solution6();
        String x = solution.convert("ABCD", 2);
        System.out.println(x);
    }

    private static void testSolution5() {
        Solution5 solution = new Solution5();
        String x = solution.longestPalindrome("aa");
        System.out.println(x);
    }

    private static void testSolution4() {
        Solution4 solution = new Solution4();
        double x = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(x);
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
