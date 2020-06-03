package com.ckm.array.medium;

public class Solution287 {
    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];

        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        slow = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }

    public int findDuplicate3(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                fast = nums[0]; //这里也是从第一个数字开始
                while(slow != fast){  //两个下标相等，此时是两个指针第二次相遇的前一个位置，下一时刻就会相遇，返回此时的下标就是重复的数字
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }


    /**
     * 二分法
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int start = 1;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt ++;
                }
            }

            if (cnt > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
