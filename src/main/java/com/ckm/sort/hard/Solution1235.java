package com.ckm.sort.hard;

import java.util.*;

public class Solution1235 {
    /**
     * 解法二
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 按结束时间排序
        int[][] items = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            items[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(items, Comparator.comparingInt(a -> a[1]));

        // dp定义及初始化
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0);
        dpProfit.add(0);

        for (int[] item : items) {
            int s = item[0], e = item[1], p = item[2];
            // find previous endTime index
            int prevIdx = Collections.binarySearch(dpEndTime, s + 1);
            if (prevIdx < 0) {
                prevIdx = -prevIdx - 1;
            }
            prevIdx--;
            int currProfit = dpProfit.get(prevIdx) + p, maxProfit = dpProfit.get(dpProfit.size() - 1);
            if (currProfit > maxProfit) {
                dpProfit.add(currProfit);
                dpEndTime.add(e);
            }
        }

        return dpProfit.get(dpProfit.size() - 1);
    }


    /**
     * 解法一
     */
    // 记录每个任务被选中时所对应的最大收益
    int[] profits;
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        // 初始化
        profits = new int[startTime.length];

        // 一个任务有3个属性，即开始时间，结束时间，任务收益，可以在开始时将三个属性合并到一起。
        int[][] jobInfos = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i ++) {
            jobInfos[i][0] = startTime[i];
            jobInfos[i][1] = endTime[i];
            jobInfos[i][2] = profit[i];
        }

        // 按开始时间排序
        Arrays.sort(jobInfos, Comparator.comparingInt(o -> o[0]));

        return helper(jobInfos, 0, 0);
    }

    /**
     * @param jobInfos 任务列表
     * @param index 当前处理任务下标
     * @param lastEndTime 当前已处理任务列表中的最大结束时间
     * @return
     */
    private int helper(int[][] jobInfos, int index, int lastEndTime) {
        if (index >= jobInfos.length) {
            return 0;
        }

        if (profits[index] > 0) {
            return profits[index];
        }

        int endTime = jobInfos[index][1];
        int profit = jobInfos[index][2];

        // 任务选中
        int nextIndex = findNextJob(jobInfos, index, endTime);
        int selectProfit = profit + helper(jobInfos, nextIndex, Math.max(endTime, lastEndTime));
        // 任务不选中
        int nonSelectProfit = helper(jobInfos, index + 1, lastEndTime);
        int result = Math.max(selectProfit, nonSelectProfit);
        profits[index] = result;
        return result;
    }

    // 当前任务被选中时下一个任务的筛选
    private int findNextJob(int[][] jobInfos, int index, int lastEndTime) {
        // 如果最后一个任务的开始时间都要早于lastEndTime，表示已经没有下一个可选了
        if(jobInfos[jobInfos.length - 1][0] < lastEndTime){
            return jobInfos.length;
        }
        // 下面开始常规二分查找
        // left为最近执行任务加一，right为最后一个任务
        int left = index + 1, right = jobInfos.length - 1;
        int mid;
        while (left < right){
            mid = (left + right) / 2;
            if (jobInfos[mid][0] < lastEndTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
