　　主要记录树相关的题目。

[TOC]

### 104 [二叉树的最大深度](../java/com/ckm/tree/easy/Solution104.java)
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

### 107 [二叉树自底向上按层遍历II](../java/com/ckm/tree/easy/Solution107.java)
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

### 108 [有序数组转化成树](../java/com/ckm/tree/easy/Solution108.java)
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
  
### 110 [平衡二叉树](../java/com/ckm/tree/easy/Solution110.java)
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

### 111 [二叉树最小深度](../java/com/ckm/tree/easy/Solution111.java)
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

### 112 [二叉树路径和](../java/com/ckm/tree/easy/Solution112.java)
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

### 235 [二叉树(BST)中节点的最近父节点(LCA)](../java/com/ckm/tree/easy/Solution235.java)
问题描述：

　　给定一个二叉搜索树(BST)，找到给定两个节点最近的公共父节点(lowest common ancestor, LCA)。节点可以为自己的父节点。

给定一个二叉树:  root = [6,2,8,0,4,7,9,null,null,3,5]，其结构如下图所示

![二叉搜索树](./images/q_235.png)

示例：

```
Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 
```

所有节点的值都是唯一的，`p`和`q`是给定树中已存在的两个不相同的值。
需要注意的是二叉搜索树某个节点如果左子树不为空，则左子树上的任意节点值都比根节点小，如果右子树不为空，则任意右子树节点值都比根节点大。

解法：

　　需要注意BST的特性，即左子树都比根小，右子树都比根大。这样就可以根据`p`和`q`的节点值递归到子树上去寻找父节点。

### 257 [二叉树的遍历路径](../java/com/ckm/tree/easy/Solution257.java)
问题描述：

　　给定一个二叉树，返回其所有从根节点到叶子节点的遍历路径。

示例：

```
Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
```

解法：

　　递归，

### 700 [BST树搜索](../java/com/ckm/tree/easy/Solution700.java)
问题描述：

　　给定一个二叉搜索树，以及一个值。从BST中找到值为给定值的那个节点。如果找不到则返回NULL。

示例：

```
Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2     
     / \   
    1   3
```

　　上面这个示例中，如果给定值为`5`，则返回`NULL`。

解法：

　　超简单，递归。略

### 590 [N叉树的后序遍历](../java/com/ckm/tree/easy/Solution590.java)
问题描述：

　　给定一个n叉树，返回节点的后序遍历值。即先遍历左子树，然后遍历右子树，最后遍历根节点的顺序。

　　递归的方式相对简单，尝试一下循环如何实现。

示例：

![示例一](images/q_590_1.png)

```
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
```

![示例二](images/q_590_2.png)

```
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
```

　　约束条件：
- 树的高度小于1000
- 总节点数介于`[0, 10^4]`之间

解法：

　　递归，略。

　　由于顺序是从最底层开始，由左到右，最后根节点。但是从根节点往下遍历时是根节点最先取得，所以应该可以想到需要借助于栈的先进后出特性。

### 589 [N叉树的前序遍历](../java/com/ckm/tree/easy/Solution589.java)
问题描述：

　　给定一个N叉树，返回其节点值的前序遍历结果。

　　除了使用递归之外，还可以尝试一下循环如何实现？

示例：

![示例一](images/q_589_1.png)

```
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
```

![示例二](images/q_589_2.png)

```
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
```

　　约束条件：
- 树的高度小于1000
- 总节点数介于`[0, 10^4]`之间

解法：

　　递归，略。

　　遍历顺序是从根节点开始，然后下一层的最左边根节点，然后从左到右依次遍历。这里仍然使用栈作为中间工具，
需要注意的是，如果按照从左到右的顺序，那么在返回结果时下一层的弹出顺序是从右到左，和期望相反。所以，在遍历子节点时，可以考虑从后往前遍历。

### 965 [二叉树是否统一值](../java/com/ckm/tree/easy/Solution965.java)
问题描述：

　　如果一个二叉树的每一个节点值都相同，则称该树"univalued"。判断一个二叉树是否"univalued"。

　　节点数为`1 ~ 100`个，节点值在`[0, 99]`范围内。

示例：

![示例一](images/q_965_1.png)

```
Input: [1,1,1,1,1,null,1]
Output: true
```

![示例二](images/q_965_2.png)

```
Input: [2,2,2,5,2]
Output: false
```

解法：

　　递归，略。太简单。

### 559 [N叉树的最大深度](../java/com/ckm/tree/easy/Solution559.java)
问题描述：

　　给定一个N叉树，计算其最大深度。最大深度是指，在从根节点遍历到叶子节点的所有不同路径中，经过节点数最多的那条路径上的节点数。

　　N叉树的深度小于1000，并且节点值在`[0, 10^4]`之间。


示例：

![示例一](images/q_559_1.png)

```
Input: root = [1,null,3,2,4,null,5,6]
Output: 3
```

![示例二](images/q_559_2.png)

```
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5
```

解法：

　　递归，参考第104题，二叉树的最大深度。N叉树的最大深度为子树最大深度加1。

### 897 [BST的结构变换](../java/com/ckm/tree/easy/Solution897.java)
问题描述：

　　给定一个二叉搜索树，调整树结构，使得最左边的节点变成根节点，并且每一个节点都没有左子节点，只有一个右子节点。

　　给定二叉树的限制条件如下，
- 树中的节点数不超过100
- 每一个节点的值为不重复的1000以内的数字

示例：

```
Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
```

解法：

　　实际上是将BST进行中序遍历顺序的调整。

　　另外可以使用递归对问题进行拆解，
- 如果左子树为空，直接调整右子树。
- 如果左子树不为空，则调整左子树，然后使左子树最后一个节点指向当前节点，然后调整右子树，使当前节点指向调整后右子树的根节点。

### 1022 [二叉树全路径二进制数求和](../java/com/ckm/tree/easy/Solution1022.java)
问题描述：

　　给定一个二叉树，每个节点的值为0或1，每一条从根节点到叶子节点的路径上的0或1组成一个二进制数字。比如路径`0 -> 1 -> 1 -> 0 -> 1`，得到的二进制数字为`01101`，十进制数为13。

　　计算所有不同路径上的数字，返回这些数字之和。

示例：

![示例一](images/q_1022.png)

```
Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

解法：

　　递归，二进制每前进一位，其对应的十进制数乘以2，那么，从root开始遍历时，每到下一层节点，当前值为上一次值乘以2，再加上当前节点。遍历这棵树上每一个节点，求和即可。

### 669 [BST范围限定](../java/com/ckm/tree/easy/Solution669.java)
问题描述：

　　给定一个二叉搜索树，以及一个区间范围`[L, R] (R >= L)`，遍历这棵树，将其中值不在该区间范围内的节点移除。

示例：

```
Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
```

解法：

　　递归，分三种情况讨论。略

### 637 [二叉树按层求平均](../java/com/ckm/tree/easy/Solution637.java)
问题描述：

　　给定一个非空二叉树，返回每一层节点值的平均值数组。节点值是32位整数范围。

示例：

```
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
```

解法：

　　二叉树的广度优先遍历，借助队列。难度在于如何确定每层的节点数，每次取元素时首先判断队列中元素的个数，全部取出来，然后把下一层放进去。

### 653 [BST的两个节点求和](../java/com/ckm/tree/easy/Solution653.java)
问题描述：

　　给定两个BST以及一个目标数字，如果BST中存在两个节点其和为目标数字，则返回true，否则返回false。

示例：

```
Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

解法：

　　首先使用递归，将BST节点值按中序遍历转换为List，然后判断有序数组中是否存在两个数字之和为给定数值。

### 538 [BST转换为Greater Tree](../java/com/ckm/tree/easy/Solution538.java)
问题描述：

　　给定一个BST，将其转换成Greater Tree。树的结构保持不变，节点值变为原始BST中节点值比当前节点值大的所有值的和。不好理解的话，看下面的示例，

示例：

```
Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
```

解法：

　　遍历BST，更新每一个节点上的值，先计算右子树的和，然后计算根节点，最后计算左子树。最终整个BST最左边叶子节点值为整棵BST全部节点值之和。

### 606 [二叉树转换为字符串输出]()
问题描述：

　　给定一个二叉树，将其按照前序方式转换为一个字符串，左右子节点在根节点数字后面的`()`中，null节点用`()`表示。另外，还需要去除无用的`()`。
比如，左子节点为null，右子节点不为空的，需要将左子节点用`()`表示，如果右子节点为null的，则不需要。

示例：

```
Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
```

解法：

　　前序遍历，递归处理
