　　主要记录类型不太好分的题目。

[TOC]

### 70 [爬楼梯](../java/com/ckm/other/Solution70.java)
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

### 62 [不同路径](../java/com/ckm/other/Solution62.java)
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

### 18 [](../java/com/ckm/other/Solution17.java)
问题描述：

　　

示例：


解法：

　　

### 18 [](../java/com/ckm/other/Solution17.java)
问题描述：

　　

示例：


解法：

　　