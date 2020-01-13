　　主要记录链表相关的题目。

[TOC]

### 2 [EASY][两数求和](../java/com/ckm/list/easy/Solution2.java)
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


### 1290 [EASY][单向链表二进制数字](../java/com/ckm/list/easy/Solution1290.java)
问题描述：

　　给定一个单向链表，链表的节点值为0或1。返回这个单向链表所有二进制数字所组成的数字。

示例：

![示例一](images/q_1290.png)

```
Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:
Input: head = [0]
Output: 0

Example 3:
Input: head = [1]
Output: 1

Example 4:
Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880

Example 5:
Input: head = [0,0]
Output: 0
```

解法：

　　遍历该链表，每次向后移动一位，前面的值乘以2.

### number [][]()
问题描述：

　　

示例：

```

```

解法：

　　
