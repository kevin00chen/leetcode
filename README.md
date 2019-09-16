　　题目列表

### 1 两数求和
问题描述：

　　给定一个整数数组，返回和为指定数字的元素下标。每个元素只能使用一次。

示例：

nums = [2, 7, 11, 15], target = 9,

nums[0] + nums[1] = 2 + 7 = 9,

返回 [0, 1].

解法：

　　除了两层遍历的暴力解法之外，还可以用HashMap来解决，遍历数组，target - 当前元素 之差如果不在该map中，则map中添加元素，否则直接返回下标。

[Solution](./src/main/java/com/ckm/normal/Solution1.java)