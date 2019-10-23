package com.ckm.tools;
import	java.util.ArrayList;

import java.util.List;

/**
 * 整数数组排序工具
 */
public class SortTool {

    /**
     * 选择排序
     * @param nums
     */
    public void selectionSort(List<Integer> nums) {
        int s = -1;
        while (s < nums.size() - 1) {
            int minIndex = s + 1;
            for (int i = s + 1; i < nums.size(); i++) {
                if (nums.get(i) < nums.get(minIndex)) {
                    minIndex = i;
                }
            }
            swapIJ(nums, s + 1, minIndex);
            s ++;
        }
    }

    /**
     * 希尔排序
     * @param nums
     */
    public void shellSort(List<Integer> nums) {
        int s = 1;

        for (int i = 1; i < nums.size(); i++) {
            int j = 0;
            while (j < s && nums.get(i) < nums.get(j)) {
                j ++;
            }

            for (int k = j; k < s; k ++) {
                nums.set(k + 1, nums.get(k));
            }
            nums.set(j, nums.get(i));
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public void insertSort(List<Integer> nums) {
        int s = 1;

        for (int i = 1; i < nums.size(); i++) {
            int j = 0;
            while (j < s && nums.get(i) < nums.get(j)) {
                j ++;
            }

            for (int k = j; k < s; k ++) {
                nums.set(k + 1, nums.get(k));
            }
            nums.set(j, nums.get(i));
        }
    }


    /**
     * 快速排序
     * @param nums
     */
    public void quickSort(List<Integer> nums) {

    }

    /**
     * 冒泡排序
     * @param nums
     */
    public void bubbleSort(List<Integer> nums) {
        for (int i = nums.size() - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums.get(i) < nums.get(j)) {
                    swapIJ(nums, i, j);
                }
            }
        }
    }

    private void swapIJ(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static void main(String[] args) {
        SortTool sort = new SortTool();
        List<Integer> nums = new ArrayList<> ();
        nums.add(3);
        nums.add(1);
        nums.add(7);
        nums.add(7);
        nums.add(4);

        sort.bubbleSort(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }
}
