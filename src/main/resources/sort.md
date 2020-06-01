　　主要记录一些排序相关的题目

[TOC]

### 992 [EASY][数组奇偶位置顺序调整](../java/com/ckm/sort/easy/Solution992.java)
问题描述：

　　给定一个非负整数数组A，其中有一半的整数为奇数另一半为偶数。
对数组的顺序进行调整，使得每个奇数位`i`上的元素`A[i]`也为奇数，偶数位`i`上的元素`A[i]`为偶数。
不要求数组元素有序。

数组满足以下条件:

- `2 <= A.length <= 20000`
- `A.length % 2 == 0`
- `0 <= A[i] <= 1000`

示例：

```
Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] 都是正确答案.
```

解法：

　　遍历数组，调整元素的位置，偶数位全部调整好后，整个数组也调整好了。

### 1122 [EASY][数组按指定顺序排序](../java/com/ckm/sort/easy/Solution1122.java)
问题描述：

　　给定两个数组`arr1`和`arr2`，`arr2`中的元素各不相同并且每一个元素都在`arr1`中存在。

　　调整`arr1`中元素的顺序，使得其中元素按照`arr2`中的元素顺序排列。并且`arr1`中不存在与`arr2`中的元素按照升序排列。

满足如下条件:

- `arr1.length, arr2.length <= 1000`
- `0 <= arr1[i], arr2[i] <= 1000`
- `arr2[i]`中的元素各不相同
- `arr2[i]`中的元素都包含在`arr1`中

示例：

```
Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
```

解法一：

　　利用一个`HashMap`，遍历数组一，记录其中每个元素的个数，然后遍历数组一，每次从中取出元素，循环几次。最后再将剩下元素排好序。

解法二：

　　由于题目中说到元素个数以及元素值是有限制的，所以在这个方法中不用`HashMap`，而用一个长度为`1001`的数组来计数。
这样既能根据下标取出元素出现的次数，又能根据下标将剩下的元素进行排序。

### 1030 [EASY][矩阵元素距离给定元素的距离排序](../java/com/ckm/sort/easy/Solution1030.java)
问题描述：

　　给定一个`R * C`的矩阵，矩阵元素为整数。以及该矩阵中的一个元素的坐标点`(r0, c0)`。按照矩阵中每个元素离给定元素的距离由小到大的顺序返回矩阵中的所有元素。

　　元素`(r1, c1)`和`(r2, c2)`之间的距离为`|r1 - r2| + |c1 - c2|`，相同距离的元素可以任意顺序。

约束条件：

- `1 <= R <= 100`
- `1 <= C <= 100`
- `0 <= r0 < R`
- `0 <= c0 < C`

示例：

```
Example 1:
Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]

Example 2:
Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.

Example 3:
Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
```

解法：

　　以给定点`(r0, c0)`为起点，分别向其上下左右以步长为1进行移动。逐步向外扩散。比如下面所示一个`4 * 3`的矩阵，给定坐标处为`1`。

```
0 0 0 0
0 0 1 0
0 0 0 0
```

　　离的最近的是自身，即`(1, 2)`，其次是距离为`1`的四个点`(0, 2), (2, 2), (1, 1), (0, 3)`，再然后是距离为`2`的点，最远距离为3。

### 349 [EASY][两个数组求交集](../java/com/ckm/sort/easy/Solution349.java)
问题描述：

　　求两个数组中元素的交集，不限定其顺序。

示例：

```
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
```

解法：

　　使用两个`Set`然后遍历其中短的那一个，判断每个元素是否在另一个`Set`中出现。

### 350 [EASY][字符串求交集II](../java/com/ckm/sort/easy/Solution350.java)
问题描述：

　　计算两个给定数组元素的交集。与上一题不相同的是，相同字符串出现几次就需要在结果中展现几次。不要求顺序。

- 如果给定数组有序，需要如何优化算法？
- 如果`nums1`的长度比`nums2`的长度小，该如何优化算法？
- 如果`nums2`中的元素存储在硬盘上，无法一次将`nums2`加载到内存中，该如何实现算法？

示例：

```
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
```

解法：

　　依次遍历数组一，记录其中每个元素出现的次数，然后遍历数组二，如果存在则次数减一。

### 976 [EASY][周长最长的三角形](../java/com/ckm/sort/easy/Solution976.java)
问题描述：

　　给定一个正整数的数组`A`，在`A`中找到可以构成三角形的三个数字，使得三角形的周长最大。如果不能构成三角形，则返回`0`。

- `3 <= A.length <= 10000`
- `1 <= A[i] <= 10^6`

示例：

```
Example 1:
Input: [2,1,2]
Output: 5

Example 2:
Input: [1,2,1]
Output: 0

Example 3:
Input: [3,2,3,4]
Output: 10

Example 4:
Input: [3,6,2,3]
Output: 8
```

解法：

　　理论上对数组排好序后，取其中最大的三个数字即可，但是三角形需要满足条件，任意两条边的两边之和大于第三条边，两边之差小于第三条边。

　　在构造三角形时，首先选择一条边，然后找另外两条满足条件的边。对`A`排好序后，首先取最大的数字组成边`c`，
然后往前找两条边`a`和`b`，使得`a + b > c`。

### 242 [EASY][异构单词判断](../java/com/ckm/sort/easy/Solution242.java)
问题描述：

　　判断字符串`s`和`t`是否为异构词。异构词是指单词中的字母及出现的次数都相同。只包含小写字母。

示例：

```
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
```

解法：

　　题目中说了给定的字符串中只包含小写字母，所以，可以用一个长度为`26`的数组计数。遍历`s`，每次在指定字符位置上加一。
然后遍历`t`，每次在指定字符位置上减一。当出现小于零的情况时，返回`false`即可。

　　另外，还可以将两个字符串进行排序，然后比对两个字符串每一个位子上的字符是不是相同。

### 1370 [EASY][字符串按字符升和降排序]()
问题描述：

　　给定一个字符串`s`，按照如下规则对该字符串中的字符重新排序，

  - Step-1，从`s`中找到最小的字符，输出结果中
  - Step-2，从`s`中找到比Step-1中那个字符大的最小字符，输出到结果中
  - Step-3，重复Step-2，直到再也无法找到合适的字符为止
  - Step-4，从`s`中找到最大的字符，输出到结果中
  - Step-5，从`s`中找到比Step-4中小的最大字符，输出到结果中
  - Step-6，重复Step-5，直到再也无法找到合适的字符为止
  - 重复Step-1到Step-6，直到处理完`s`中的全部字符
  - 在每一步中，每次只能处理一个字符

示例：

```
  Example 1:
  Input: s = "aaaabbbbcccc"
  Output: "abccbaabccba"

  第一轮：
  Step-1的输出为a，Step-2的输出为b，Step-3的输出为c，abc
  Step-4的输出为c，Step-5的输出为b，Step-6的输出为a，abccba
  接下来进行第二轮：
  Step-1的输出为a，Step-2的输出为b，Step-3的输出为c，abc，abccbaabc
  Step-4的输出为c，Step-5的输出为b，Step-6的输出为a，abccbaabccba

  Example 2:
  Input: s = "rat"
  Output: "art"

  Example 3:
  Input: s = "leetcode"
  Output: "cdelotee"

  Example 4:
  Input: s = "ggggggg"
  Output: "ggggggg"

  Example 5:
  Input: s = "spo"
  Output: "ops"
```

解法：

　　首先遍历一次字符串，统计出其中每个字符出现的次数，这里升序降序取了一个很巧妙的方法。可以想象一下26个字符`abc ~ xyz`，升序时是从左到右遍历，降序时是从右到左遍历。
如果有一个指针，在26个字母上来回扫描，就刚好符合题目中的要求。

　　如果当前已经遍历到`z`了，那么接下来`dir`需要为`-1`，表示降序排列，如果遍历到`a`了，那么需要调整`dir`为`1`，表示升序的方向。在遍历过程中，每一个字符都存入输出变量中，然后将计数减一，以及处理过的字符数减一。

### number [][]()
问题描述：

　　

示例：

```

```

解法：

　　
