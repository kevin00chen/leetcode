package com.ckm.normal;

import com.ckm.array.Solution1;
import com.ckm.array.Solution2;
import com.ckm.array.Solution4;
import com.ckm.common.ListNode;
import com.ckm.number.Solution7;
import com.ckm.string.Solution3;
import com.ckm.string.Solution5;
import com.ckm.string.Solution6;
import com.ckm.string.Solution8;
import com.ckm.struct.LRUCache;
import com.ckm.struct.LFUCache;

public class SolutionTest {

    public static void main(String[] args) {
        testSolution8();
    }

    private static void testSolution8() {
        Solution8 solution = new Solution8();
        int x = solution.myAtoi(" ");
        System.out.println();
    }

    private static void testSolution460() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Object x4 = cache.get(1); // 1
        cache.put(3, 3);
        x4 = cache.get(2); // -1
        x4 = cache.get(3); // 3
        cache.put(4, 4);
        x4 = cache.get(1); // -1 1
        x4 = cache.get(3); //  3 -1
        x4 = cache.get(4); //  4 4

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        Object x3 = cache.get(1); // -1
        x3 = cache.get(2); // 3

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(1, 3);
        cache.put(4, 1);
        Object x2 = cache.get(1);
        x2 = cache.get(2);

        Object x1 = cache.get(2);
        cache.put(2, 6);
        x1 = cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        x1 = cache.get(1);
        x1 = cache.get(2);
        System.out.println();

        cache.put(1, 1);
        cache.put(2, 2);
        Object x = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        x = cache.get(2);       // returns -1 (not found)
        x = cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        x = cache.get(1);       // returns -1 (not found)
        x = cache.get(3);       // returns 3
        x = cache.get(4);       // returns 4
        System.out.println();
    }

    private static void testSolution146() {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        Object y = cache.get(2);
        cache.put(2, 6);
        y = cache.get(2);
        y = cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        y = cache.get(1);
        y = cache.get(2);



        cache.put(1, 1);
        cache.put(2, 2);
        Object x = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        x = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        x = cache.get(1);       // returns -1 (not found)
        x = cache.get(3);       // returns 3
        x = cache.get(4);       // returns 4


    }


    private static void testSolution7() {
        Solution7 solution = new Solution7();
        int x = solution.reverse(1534236469);
        System.out.println(x);
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
