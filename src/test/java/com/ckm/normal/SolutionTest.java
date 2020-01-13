package com.ckm.normal;

import com.ckm.array.*;
import com.ckm.common.ListNode;
import com.ckm.common.TreeNode;
import com.ckm.list.easy.*;
import com.ckm.list.normal.*;
import com.ckm.number.Solution12;
import com.ckm.number.Solution7;
import com.ckm.number.Solution9;
import com.ckm.other.Solution64;
import com.ckm.string.*;
import com.ckm.struct.LRUCache;
import com.ckm.struct.LFUCache;
import com.ckm.tree.easy.*;
import com.ckm.tree.hard.*;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {

    public static void main(String[] args) throws Exception {
        testSolution876();
    }

    private static void testSolution876() {
        Solution876 solution876 = new Solution876();
        ListNode x = solution876.middleNode(stringToListNode("[1,2,3,4,5,6]"));
        System.out.println();
    }

    private static void testSolution19() {
        Solution19 solution19 = new Solution19();
        ListNode x = solution19.removeNthFromEnd(stringToListNode("[1,2,3]"), 2);
    }

    private static void testSolution1290() {
        Solution1290 solution1290 = new Solution1290();
        int x = solution1290.getDecimalValue(stringToListNode("[1,0,1]"));
    }

    private static void testSolution99() {
        Solution99 solution99 = new Solution99();
        solution99.recoverTree(stringToTreeNode("[1,3,null,null,2]"));
    }

    private static void testSolution834() throws Exception {
        Solution834 solution834 = new Solution834();
        FileInputStream inputStream = new FileInputStream("/Users/chenkaiming/files/workspace/personal/leetcode/src/test/java/com/ckm/normal/array.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        int[][] nums = new int[9999][2];
        String str = null;
        int i = 0;
        while((str = bufferedReader.readLine()) != null) {
            nums[i][0] = Integer.parseInt(str.split(",")[0]);
            nums[i][1] = Integer.parseInt(str.split(",")[1]);
            i ++;
        }

        solution834.sumOfDistancesInTree(10000, nums);
        System.out.println();
    }

    private static void testSolution297() {
        Solution297 solution297 = new Solution297();
        String x = solution297.serialize(stringToTreeNode("[1,2]"));
        TreeNode t = solution297.deserialize(x);
        System.out.println();
    }

    private static void testSolution1028() {
        Solution1028 solution1028 = new Solution1028();
        TreeNode t = solution1028.recoverFromPreorder("1-401--349---90--88");
        System.out.println();
    }

    private static void testSolution671() {
        Solution671 solution671 = new Solution671();
        int x = solution671.findSecondMinimumValue(stringToTreeNode("[2,2,5,null,null,5,7]"));
        System.out.println();
    }

    private static void testSolution110() {
        Solution110 solution110 = new Solution110();
        boolean x = solution110.isBalanced(stringToTreeNode("[1,2,2,3,null,null,3,4,null,null,4]"));
        System.out.println();
    }

    private static void testSolution437() {
        Solution437 solution437 = new Solution437();
        int x = solution437.pathSum(stringToTreeNode("[1,-2,-3,1,3,-2,null,-1]"), -1);
        System.out.println();
    }

    private static void testSolution543() {
        Solution543 solution543 = new Solution543();
        int x = solution543.diameterOfBinaryTree(stringToTreeNode("[1,2,3,4,5]"));
        System.out.println();
    }

    private static void testSolution404() {
        Solution404 solution404 = new Solution404();
        int x = solution404.sumOfLeftLeaves(stringToTreeNode("[3,9,20,null,null,15,7]"));
        System.out.println();
    }

    private static void testSolution530() { // 519
        Solution530 solution530 = new Solution530();
        int x = solution530.getMinimumDifference(stringToTreeNode("[0,null,2236,1277,2776,519]"));
        System.out.println();
    }

    private static void testSolution687() {
        Solution687 solution687 = new Solution687();
        int x = solution687.longestUnivaluePath(stringToTreeNode("[1,null,1,1,1,1,1,1]"));
        System.out.println();
    }

    private static void testSolution538() {
        Solution538 solution538 = new Solution538();
        TreeNode node = solution538.convertBST(stringToTreeNode("[2,0,3,-4,1]"));
        System.out.println();
    }

    private static void testSolution897() {
        Solution897 solution897 = new Solution897();
        TreeNode t = solution897.increasingBST(stringToTreeNode("[5,3,6,2,4,null,8,1,null,null,null,7,9]"));
        System.out.println();
    }

    private static void testSolution257() {
        TreeNode root = stringToTreeNode("[1,2,3,null,5]");
        Solution257 solution257 = new Solution257();
        Object x = solution257.binaryTreePaths(root);
        System.out.println();
    }

    private static void testSolution112() {
        TreeNode root = stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        Solution112 solution112 = new Solution112();
        boolean x = solution112.hasPathSum(root, 22);
        System.out.println();
    }

    private static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    private static void testSolution108() {
        Solution108 solution108 = new Solution108();
        TreeNode x = solution108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println();
    }

    private static void testSolution104() {
        Solution104 solution104 = new Solution104();
        solution104.maxDepth(null);
    }

    private static void testSolution32() {
        Solution32 solution32 = new Solution32();
        int x = solution32.longestValidParentheses("(()))())(");
        System.out.println();
    }

    private static void testSolution44() {
        Solution44 solution44 = new Solution44();
        boolean x = solution44.isMatch("aa", "*");
        System.out.println();
    }

    private static void testSolution72() {
        Solution72 solution72 = new Solution72();
        int x = solution72.minDistance("horse", "ros");
        System.out.println();
    }

    public static void testSolution64() {
        Solution64 solution64 = new Solution64();
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int x = solution64.minPathSum(grid);
        System.out.println();
    }

    private static void testSolution53() {
        Solution53 solution53 = new Solution53();
        int[] x = new int[]{-2,1,-3,4};
        int y = solution53.maxSubArray(x);
        System.out.println();
    }

    private static void testSolution18() {
        Solution18 solution = new Solution18();
        // -1 0 2 3
        Object x = solution.fourSum(new int[]{-1,-3,-2,2,3,-3,0,-4}, 4);
        System.out.println();
    }

    private static void testSolution17() {
        Solution17 solution = new Solution17();
        Object x = solution.letterCombinations("23");
        System.out.println();
    }

    private static void testSolution16() {
        Solution16 solution16 = new Solution16();
        int[] nums = new int[]{0, 1, 2};
        // 1 9 70
        int x = solution16.threeSumClosest(nums, 3);
        System.out.println();
    }

    private static void testSolution15() {
        Solution15 solution15 = new Solution15();
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        Object x = solution15.threeSum(nums);
        System.out.println();
    }

    private static void testSolution14() {
        Solution14 solution14 = new Solution14();
        String x = solution14.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println();
    }

    private static void testSolution13() {
        Solution13 solution = new Solution13();
        int x = solution.romanToInt("MCMXCIV");
        System.out.println();
    }

    private static void testSolution12() {
        Solution12 solution = new Solution12();
        String x = solution.intToRoman(1994); // MCMXCIV
        System.out.println();
    }

    private static void testSolution287() {
        Solution287 struct = new Solution287();
        int m = struct.findDuplicate(new int[]{3,1,3,4,2});
        System.out.println();
    }

    private static void testSolution11() {
        Solution11 solution = new Solution11();
        int[] h = new int[]{2,3,4,5,18,17,6};
        int x = solution.maxArea(h);
        int y = solution.maxArea1(h);
        System.out.println();
    }

    private static void testSolution10() {
        Solution10 solution = new Solution10();
        boolean r = solution.isMatch("a", "aa");
        System.out.println();
    }

    private static void testSolution9() {
        Solution9 solution = new Solution9();
        boolean x = solution.isPalindrome(121);
        System.out.println();
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

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}
