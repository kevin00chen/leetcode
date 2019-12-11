　　主要记录树相关的题目。

[TOC]

### 104 [二叉树的最大深度](../java/com/ckm/tree/Solution104.java)
问题描述：

　　给定一个二叉树，计算其最大深度。二叉树的最大深度是指该二叉树从根节点到最远的那个叶子节点最大长度上所经过的节点数。

示例：

```
Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
```

解法：

　　递归，当前节点为`null`时返回`0`，否则，结果为其左右子树的最大深度加1.

### 107 [二叉树自底向上按层遍历II](../java/com/ckm/tree/Solution107.java)
问题描述：

　　给定一个二叉树，从底向上返回其各层节点上的节点值。（从叶子节点开始，从左往右遍历）

示例：

```
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
```

解法：

　　递归，需要注意最后要将`List`进行翻转。

### 108 [有序数组转化成树](../java/com/ckm/tree/Solution108.java)
问题描述：

　　给定一个升序排列的数组，将其转化成一个"height balanced"二叉树。
"height balanced"二叉树的定义是，这棵树的每个节点其两个子树深度差不能超过1。

示例：

```
  Example:
  
  Given the sorted array: [-10,-3,0,5,9],
  
  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
  
        0
       / \
     -3   9
     /   /
   -10  5
```

解法：

　　递归，首先计算数组的长度，每次对数组进行二分，即将元素分为左右两边大致相等的节点数。
  
### 110 [平衡二叉树](../java/com/ckm/tree/Solution110.java)
问题描述：

　　给定一个二叉树，判断它是不是"height-balanced"，
"height-balanced"的定义是任意节点的左右子树高度差不超过1。

示例：

```
Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
```

解法：

　　递归，分别遍历左右子节点，每次路径长度加1，每次树是否为平衡树的判断时，由当前节点是否平衡与子树是否平衡共同判断。

### 111 [二叉树最小深度](../java/com/ckm/tree/Solution111.java)
问题描述：

　　给定一个二叉树，找到其最小深度。
二叉树的最小深度是指，从根节点遍历到最近的叶子节点路径上所经过的节点数。

示例：

```
Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
```

解法：

　　递归，左右子树深度谁小取谁。但是如果只有一个子树，就取该子树的深度。

### 112 [二叉树路径和](../java/com/ckm/tree/Solution112.java)
问题描述：

　　给定一个二叉树，以及一个数字。判断给定二叉树从根节点遍历到叶子节点的所有路径中，有没有哪条路径上所有节点值的和等于给定数字。

示例：

```
Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
```

解法：

　　递归，退出条件为，当前节点左右都为空，需要`sum == root.val`，如果左为空，需要右子树满足条件，如果右为空，需要左子树满足条件。

### 8 [](../java/com/ckm/tree/Solution1.java)
问题描述：

　　

示例：


解法：

　　