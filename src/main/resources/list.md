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

### 19 [NORMAL][移除List倒数第N个节点](../java/com/ckm/list/normal/Solution19.java)
问题描述：

　　给定一个List，只遍历List一次，移除从后往前的第N个节点。

示例：

```
Example:

Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
```

解法：

　　定义一个长度为`n + 1`的滑动窗户，当窗口最后一个元素滑动到最后一个元素时停止滑动，去除该窗口第一个元素即可。

### 876 [EASY][单向链表中间节点](../java/com/ckm/list/easy/Solution876.java)
问题描述：

　　给定一个非空单向链表，返回该链表的中间节点。如果中间节点有两个，返回其中的第二个节点。

示例：

```
Example 1:
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

Example 2:
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
```

解法：

解法一：
　　遍历该链表元素，第一个节点时，返回第一个元素，然后后续连续两个节点都只往后移动一个节点。比如

```
1 -> 1
1,2,3 -> 2
1,2,3,4,5 -> 3
1,2,3,4,5,6 -> 4
```

解法二：
　　快慢指针。

### 206 [EASY][单向链表的反转](../java/com/ckm/list/easy/Solution206.java)
问题描述：

　　反转单向链表，分别使用循环和递归实现。

示例：

```
Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

解法：

　　详见代码注释，略。

### 237 [EASY][单向链表删除节点](../java/com/ckm/list/easy/Solution237.java)
问题描述：

　　给定一个最少包含两个节点的单向链表，实现一个删除节点的函数，删除当前节点。

示例：

给定一个链表，`head = [4,5,1,9]`, 如下图所示

![示例一](images/q_237.png)

```
Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

Example 2:
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

解法：

　　略

### 21 [EASY][两个有序链表的合并](../java/com/ckm/list/easy/Solution21.java)
问题描述：

　　给定两个有序的链表，将其按顺序合并成一个新的链表。

示例：

```
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

解法：

　　

### 83 [EASY][去除有序链表重复元素](../java/com/ckm/list/easy/Solution83.java)
问题描述：

　　给定一个排好序的链表，删除链表中的重复数字的节点。

示例：

```
Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
```

解法：

　　循环，使用两个指针，以及一个记录当前节点值的变量。当遇到不相同的值时，调整两个指针的指向，直接跳过中间相同元素。

### 141 [EASY][判断链表是否有环](../java/com/ckm/list/easy/Solution141.java)
问题描述：

　　给定一个链表，判断其中是否有环。 非负整数`pos`表示链表的尾部指向的节点下标。如果`pos = -1`则没有环。空间复杂度`O(1)`。

示例：

![示例一](images/q_141_1.png)

```
Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

```

![示例二](images/q_141_2.png)

```
Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

![示例三](images/q_141_3.png)

```
Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```

解法：

　　快慢指针。

### 234 [EASY][回文链表判断](../java/com/ckm/list/easy/Solution234.java)
问题描述：

　　给定一个单向链表，判断其中的元素是否回文。时间复杂度`O(n)`，空间复杂度`O(1)`。

示例：

```
Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

```

解法：

　　将单向链表翻转，然后与原链表进行比对即可。或者可以翻转一半链表，然后与原链表进行一一比对。具体可以参考代码注释。

### number [][]()
问题描述：

　　

示例：

```

```

解法：

　　
