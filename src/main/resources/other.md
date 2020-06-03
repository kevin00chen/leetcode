　　主要记录类型不太好分的题目。

[TOC]

### 70 [EASY][爬楼梯](../java/com/ckm/other/Solution70.java)
问题描述：

　　给定一个`n`阶的楼梯，每次可以往上爬1格或者2格。求出爬到顶部总共有多少种可能的方案。

示例：

```
Example 1:
Input: 2
Output: 2
Explanation: 有两种方案.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output: 3
Explanation: 有3种方案.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

解法：

　　递归，动态规划

### 62 [MEDIUM][不同路径](../java/com/ckm/other/Solution62.java)
问题描述：

　　给定一个`m x n`的二维网格地图，地图上有一个机器人，每次只能往下或者往右走一步。机器人需要从左上角的'Start'处走到右下角的'Finish'处。总共有多少种可能的路线。

![示意图](./images/q_62.png)

　　上图给定的是一个`7 x 3`的网格。给定的`m`和`n`不会超过100.

示例：

```
Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28
```

解法：

　　动态规划，定义一个二维数组`fn[m][n]`，`fn[i][j]`表示到点`(i, j)`时的所有可能路径情况。那么`fn[m][n] = fn[m - 1][n] + fn[m][n - 1]`。
需要注意一些特定点位的初始化。由于题目规定，只能往下或者往右走，所以，最左边一列以及最上面一行的值全部为1。

### 63 [MEDIUM][不同路径II](../java/com/ckm/other/Solution63.java)
问题描述：

　　有一个机器人位于`m x n`网格的左上角，每次只能往下或者往右移动一格。机器人需要从左上角`Start`移动到右下角的`Finish`处。
和上面相比，新的网格中会有一些障碍物。求总共有多少种遍历路径。

输入中用数字1表示障碍

![示意图](./images/q_62.png)

　　上图给定的是一个`7 x 3`的网格。给定的`m`和`n`不会超过100。

示例：

```
Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
```

解法：

　　和上面类似，动态规划，定义一个二维数组`fn[m][n]`，`fn[i][j]`表示到点`(i, j)`时的所有可能路径情况。那么`fn[m][n] = fn[m - 1][n] + fn[m][n - 1]`。

　　需要注意一些特定点位的初始化。由于题目规定，只能往下或者往右走，所以，最左边一列以及最上面一行的值全部为1。

　　但是，最左边一列和最上面一行，当出现一个障碍物时，后续所有区域都不可达。并且，在后续遍历时，只判断没有障碍物的点。

### 64 [MEDIUM][二维网格最小路径和](../java/com/ckm/other/Solution64.java)
问题描述：

　　给定一个`m x n`的网格，每个格子中都有非负整数。找到从左上角遍历到左下角时所有数字之和最小的路径，并返回该最小值。

　　遍历只能往下或者往右。

示例：

```
Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
```

解法：

　　动态规划，`fn[i][j]`表示到点`(i, j)`的最小路径和。`fn[m][n] = Min(fn[m - 1][n] + nums[m][n], fn[m][n - 1] + nums[m][n])`。

　　最上面一行和最左边一列特殊处理。

### 18 [](../java/com/ckm/other/Solution17.java)
问题描述：

　　

示例：


解法：

　　
