　　主要记录数组相关的题目。

[TOC]

### 1 [两数求和](../java/com/ckm/array/Solution1.java)
问题描述：

　　给定一个整数数组，返回和为指定数字的元素下标。每个元素只能使用一次。

示例：
```
nums = [2, 7, 11, 15], target = 9,

nums[0] + nums[1] = 2 + 7 = 9,

返回 [0, 1].
```
解法：

　　除了两层遍历的暴力解法之外，还可以用HashMap来解决，遍历数组，target - 当前元素 之差如果不在该map中，则map中添加元素，否则直接返回下标。

### 2 [两数求和](../java/com/ckm/array/Solution2.java)
问题描述：

　　给定两个非空的非负整数linked list，每个list中的每位数字表示一个倒序的整数，计算这两个整数的求和结果。结果仍然以倒序整数的linked list表示。

示例：

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

解法：

　　遍历两个数组，如果数组仍然有元素或者上一轮求和结果大于10，则继续遍历，每次相加结果的个位数存入结果集。

### 4 [两个有序数组中位数计算](../java/com/ckm/array/Solution4.java)
问题描述：

　　两个排好序的数组（两个数组不同时为空），分别包含m个和n个元素，计算中位数。时间复杂度`O(log (m+n))`

示例：

```
Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```

解法：

　　

### 8 [](../java/com/ckm/array/Solution1.java)
问题描述：

　　

示例：


解法：

　　