　　主要记录树相关的题目。

[TOC]

### 104 [EASY][二叉树的最大深度](../java/com/ckm/tree/easy/Solution104.java)
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

### 107 [EASY][二叉树自底向上按层遍历II](../java/com/ckm/tree/easy/Solution107.java)
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

### 108 [EASY][有序数组转化成树](../java/com/ckm/tree/easy/Solution108.java)
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
  
### 110 [EASY][平衡二叉树](../java/com/ckm/tree/easy/Solution110.java)
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

### 111 [EASY][二叉树最小深度](../java/com/ckm/tree/easy/Solution111.java)
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

### 112 [EASY][二叉树路径和](../java/com/ckm/tree/easy/Solution112.java)
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

### 235 [EASY][二叉树(BST)中节点的最近父节点(LCA)](../java/com/ckm/tree/easy/Solution235.java)
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

### 257 [EASY][二叉树的遍历路径](../java/com/ckm/tree/easy/Solution257.java)
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

### 700 [EASY][BST树搜索](../java/com/ckm/tree/easy/Solution700.java)
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

### 590 [EASY][N叉树的后序遍历](../java/com/ckm/tree/easy/Solution590.java)
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

### 589 [EASY][N叉树的前序遍历](../java/com/ckm/tree/easy/Solution589.java)
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

### 965 [EASY][二叉树是否统一值](../java/com/ckm/tree/easy/Solution965.java)
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

### 559 [EASY][N叉树的最大深度](../java/com/ckm/tree/easy/Solution559.java)
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

### 897 [EASY][BST的结构变换](../java/com/ckm/tree/easy/Solution897.java)
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

### 1022 [EASY][二叉树全路径二进制数求和](../java/com/ckm/tree/easy/Solution1022.java)
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

### 669 [EASY][BST范围限定](../java/com/ckm/tree/easy/Solution669.java)
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

### 637 [EASY][二叉树按层求平均](../java/com/ckm/tree/easy/Solution637.java)
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

### 653 [EASY][BST的两个节点求和](../java/com/ckm/tree/easy/Solution653.java)
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

### 538 [EASY][BST转换为Greater Tree](../java/com/ckm/tree/easy/Solution538.java)
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

### 872 [EASY][相似叶子节点二叉树](../java/com/ckm/tree/easy/Solution872.java)
问题描述：

　　从左到右观察两棵二叉树的叶子节点，如果值全部相同，则认为两棵树叶子节点值序列相同

示例：

![二叉树叶子节点](images/q_872.png)

　　上图中叶子节点序列为`(6, 7, 4, 9, 8)`。如果另一棵二叉树叶子节点序列也是这样，那么就认为这两棵二叉树`leaf-similar`。

解法：

　　深度优先两棵树，比较返回的结果是否一致。

### 501 [EASY][查找BST中重复次数最多的元素](../java/com/ckm/tree/easy/Solution501.java)
问题描述：

　　给定一个有重复值的BST，找到该BST中所有重复次数最多的元素。（可能会存在多个重复值出现次数相同，此时返回一个数组）

　　尝试一下不使用额外的存储空间。

示例：

```
For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].
```

解法：

　　中序遍历BST，如果当前节点值和上次值相同，则计数加1，如果不同，则停止计数。如果停止计数时计数值大于max，则更新max值，并清空结果集，同时将新节点值存入结果集中。
如果等于max，则往结果集中添加当前元素。

### 687 [EASY][二叉树最长相同值子路径](../java/com/ckm/tree/easy/Solution687.java)
问题描述：

　　给定一个二叉树，找到这棵树中节点值连续相同的子路径。路径长度为节点之间连线的条数，即节点数减一。路径不要求经过根节点或者叶子节点。

示例：

```
Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2

 

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2
```

解法：

　　递归，首先计算左子树能取得的最大值，然后计算右子树能取到的最大值。然后，如果当前节点等于左子树根节点值，那么左边的值需要再加1，同理，如果右子树根节点值等于当前节点值，
那么右边的长度也可以延迟1。所以，只有当前节点值同时等于左子根节点以及右子根节点时，这两个值才会都不等于0，此时，两边的路径可以经过根节点串起来。

### 606 [EASY][二叉树转换为字符串输出](../java/com/ckm/tree/easy/Solution606.java)
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

### 530 [EASY][计算BST任意节点间最小差值](../java/com/ckm/tree/easy/Solution530.java)
问题描述：

　　给定一个非负值BST，找到其中最小的节点差值。节点无需连续。

示例：

```
Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
```

解法：

　　根据BST的特性，所有左子节点都比当前节点值小，所有右子节点都比当前节点值大。所以，最小差值一定在最左右子节点-根节点，或者根节点-最右左子节点中产生。

### 993 [EASY][判断二叉树中给定两个节点是否为堂兄弟节点](../java/com/ckm/tree/easy/Solution993.java)
问题描述：

　　在一棵二叉树中，根节点的深度定义为`0`，第`k`层节点的子节点深度为`k+1`。如果有两个节点在同一深度，但是其父节点不相同，则称这两个节点为堂兄弟节点。
给定一个不含重复值的二叉树，以及两个数字`x`和`y`，需要判断值为`x`和`y`的这两个节点在二叉树中是否为堂兄弟节点。

示例：

Example 1:

![示例一](images/q_993_1.png)

```
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
```

Example 2:

![示例二](images/q_993_2.png)

```
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
```

Example 3:

![示例三](images/q_993_3.png)

```
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
```

解法：

　　分别判断给定的`x`和`y`是否在同一深度，以及是否是同一根节点下的子节点。

### 783 [EASY][BST节点最小差](../java/com/ckm/tree/easy/Solution783.java)
问题描述：

　　给定一个BST，返回二叉树中任意节点之间最小的差值。

示例：

```
Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

最小差值为1，出现在节点1和节点2之间，或者节点3和节点2之间，或者节点4和节点3之间
```

解法：

　　最小值只会出现在根节点与最右左子节点之间，或者根节点与最左右子节点之间。遍历这棵树，用一个变量维持最小值即可。

### 404 [EASY][二叉树叶子节点求和](../java/com/ckm/tree/easy/Solution404.java)
问题描述：

　　对给定的二叉树所有左叶子节点求和。

示例：

```
Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
```

解法：

　　遍历二叉树，当节点左右都为null，并且是上一层的左节点时，才更新sum。否则递归遍历左子树以及右子树。

### 543 [EASY][二叉树最长子路径](../java/com/ckm/tree/easy/Solution543.java)
问题描述：

　　给定一个二叉树，计算二叉树的直径。二叉树的直径定义是，该二叉树中最长的路径，这个路径可以经过也可以不经过根节点。长度是指节点之间的边数，而不是路径经过的节点数。

示例：

```
Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5  
结果为3，是路径 [4,2,1,3] 或 [5,2,1,3]的长度
```

解法：

　　有点类似于题目687，二叉树最长相同值子路径，这里不判断相同值，改为找最长路径了。

### 563 [EASY][二叉树节点倾斜程度](../java/com/ckm/tree/easy/Solution563.java)
问题描述：

　　给定一个二叉树，返回全部节点的倾斜程度之和。

　　节点的倾斜程度定义是，左子树节点值之和与由子树节点之和差的绝对值。整棵树的倾斜程度是全部节点倾斜程度之和。null节点倾斜值为0。

示例：

```
Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
节点 2 : 0
节点 3 : 0
节点 1 : |2-3| = 1
整棵树 : 0 + 0 + 1 = 1
Note:
```

解法：

　　遍历整棵树，计算每个节点左子树及右子树之和，然后求倾斜程度，最后汇总到一个全局倾斜度变量中。递归计算子树节点和，递归处理。

### 437 [EASY][二叉树和为指定值的全部路径]()
问题描述：

　　给定一个二叉树，找到树中路径上节点之和为给定值的所有路径。路径不必经过根节点，但必须只能向下延伸。

示例：

```
Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```

解法：

　　增加一个方法，判断从根节点开始往下遍历时是否满足路径和为给定值。那么对于题目要求，可以转换为三部分，这三部分加起来即为所求结果。

- 从根节点开始，有几条路径
- 不从根节点开始，左子树中有几条路径
- 不从根节点开始，右子树中有几条路径

　　在判断包含当前节点的路径和中，分别可以求当前节点是否等于给定求和值，左右子树中以当前节点为顶点路径中是否和未给定值-父节点值 

### 671 [EASY][查找特定二叉树中第二小值](../java/com/ckm/tree/easy/Solution671.java)
问题描述：

　　给定一个特定的节点值为非负整数的非空二叉树，并且每个节点要么没有子节点，要么有两个子节点。如果有两个子节点，那么当前节点的值是子节点中最小的那个值。
即始终满足条件`root.val = min(root.left.val, root.right.val)`。

　　需要在给定的二叉树中，找出整棵树中不同节点值中第二小的。如果不存在第二小值，那么返回`-1`。

示例：

```
Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
```

解法：

　　根据树的定义以及递推关系式可知，根节点的值是最小值。但是我们需要求第二小值，在后续处理过程中需要用到该最小值，所以定义一个`min`变量存该值。
另外定义一个变量`ans`存计算的结果，`ans`初始值为`Long.MAX_VALUE`。

　　深度遍历该树，如果当前节点值比`min`大，并且小于当前的`ans`，就需要用当前节点值替换掉`ans`，否则继续遍历左右子树。

　　由于`min`值固定，求第二小值的整个过程类似于求`min`值。

### 1028 [HARD][先序深度遍历字符串还原二叉树](../java/com/ckm/tree/hard/Solution1028.java)
问题描述：

　　按先序深度遍历顺序遍历一棵二叉树，每一个节点值前面输出`D`个中划线(`D`为当前节点的深度)。如果某个节点的深度为`D`，那么它的直接子节点深度为`D + 1`，根节点的深度为0。
如果某个节点只有一个子节点，这个子节点一定是左子节点。

　　给定输入字符串，根据该字符串还原出一棵二叉树。

示例：

Example 1:

![示例一](images/q_1028_1.png)

```
Input: "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]
```

Example 2:

![示例二](images/q_1028_2.png)

```
Input: "1-2--3---4-5--6---7"
Output: [1,2,5,3,null,6,null,4,null,7]
```

Example 3:

![示例三](images/q_1028_3.png)

```
Input: "1-401--349---90--88"
Output: [1,401,null,349,88,90]
```

解法：

　　类似于二分查找，根据当前深度，遍历字符串，然后从中间将剩余字符串分割成左右两部分。递归左右两部分继续求其组成的树，分别当作当前节点的左右子树。

### 297 [HARD][二叉树的序列化与反序列化](../java/com/ckm/tree/hard/Solution297.java)
问题描述：

　　序列化是将一个数据结构或对象转化成bits序列，然后可以方便的存储到文件，或者内存中，或者通过网络进行传输。反序列化是将接受到的bits序列还原成原数据结构或对象。

　　这个题目要求将一个二叉树序列化成字符串，然后又可以根据该字符串反序列化成原来的树状结构。

示例：

```
Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
```

　　上面示例中是当前LeetCode中常用的方法，实现时可以不必要按照这种格式对树进行序列化。只要可以根据序列化的结果将其还原即可。

解法：

　　序列化比较相对简单，深度遍历二叉树，遇到空节点用`null`表示。

### 834 [HARD][N叉树节点间路径距离和](../java/com/ckm/tree/hard/Solution834.java)
问题描述：

　　给定N个节点，节点值为`[0, N - 1]`，以及`N - 1`条边。第`i`条边连接节点`edges[i][0]`和`edges[i][1]`。

　　求`ans`数组，其中`ans[i]`表示节点`i`到其他全部节点的距离。

示例：

```
Example 1:
Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
```

解法：

　　

### number [][]()
问题描述：

　　

示例：

```

```

解法：

　　
