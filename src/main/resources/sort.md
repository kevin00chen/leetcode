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

### 1370 [EASY][字符串按字符升和降排序](../java/com/ckm/sort/easy/Solution1370.java)
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

### 1403 [EASY][寻找最短降序子序列使其和比其他元素和大](../java/com/ckm/sort/easy/Solution1403.java)
问题描述：

　　给定一个数字数组，从该数组中找到一个子数组，使得该子数组的元素之和比不在该子数组中其他的元素之和要大。

　　如果有多个解，那么返回元素最少的那个子数组，如果还是有多个解，就返回和最大的那个。
  
 ```
  1 <= nums.length <= 500
  1 <= nums[i] <= 100
```

示例：

```
  Example 1:
  Input: nums = [4,3,10,9,8]
  Output: [10,9] 
  Explanation: 符合条件的子数组有 [10,9] 和 [10,8] 但是 [10,9] 的和更大

  Example 2:
  Input: nums = [4,4,7,6,7]
  Output: [7,7,6] 
  Explanation: [7,7] 的和为14，但是剩下元素之和也为14 (14 = 4 + 4 + 6). [7,6,7] 是和最大的那个. 输出结果需要降序排列

  Example 3:
  Input: nums = [6]
  Output: [6]
```

解法：

　　数组长度小于500，并且数组元素的值小于100，使用一个长度为100的数组`n`，记录每个数值的元素出现的次数，同时使用一个变量`sum`来求和。接下来从后往前在`n`中取出元素，取出的元素看看和到了多少。直到和比剩下元素之和大为止。

### 1356 [EASY][数组按二进制中1的个数升序排序](../java/com/ckm/sort/easy/Solution1356.java)
问题描述：

　　给定一个整数数组`arr`，按照数组中每个元素表示为二进制时`1`的个数由少到多排序。如果`1`的个数相同，按数字大小升序。返回排好序的数组。

```
1 <= arr.length <= 500
0 <= arr[i] <= 10^4
```

示例：

```
Example 1:
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:
Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.

Example 3:
Input: arr = [10000,10000]
Output: [10000,10000]

Example 4:
Input: arr = [2,3,5,7,11,13,17,19]
Output: [2,3,5,17,7,11,13,19]

Example 5:
Input: arr = [10,100,1000,10000]
Output: [10,100,10000,1000]
```

解法：

　　定义一个优先队列，优先级按数字二进制表示中`1`的个数排序，如果相同则按数字大小。

### 1329 [MEDIUM][矩阵对角排序](../java/com/ckm/sort/easy/Solution1329.java)
问题描述：

　　给定一个`m * n`的整数矩阵，对每一条对角线，按照从左上到右下的顺序降序排列。

　　其中`m`为矩阵的行数，`n`为矩阵的列数，并且行列数范围为`[1, 100]`，元素值范围为`[1, 100]`
 
示例：

![示例一](./images/q_1329.png)

```
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
```

解法：

　　二维数组，从左上角到右下角移动，每次下一个元素是行和列都加`1`，如果行或者列到了边上，就不需要移动了。对这些元素整体排序，调整位置。

　　按照习惯，从左下角开始，然后依次遍历到右上角，即如图中所示，先处理左下角的1，最后处理右上角的1。定义一个长度为101的数组，每次处理一条对角线时清空。

　　对于一个`m * n`的矩阵来说，对角线的起始点是所有第一行以及第一列，但是左上角的那个元素只能计算一次，所以，最终需要排序的对角线有`m + n - 1`条。

### 1305 [MEDIUM][两个二叉搜索树中元素排序](../java/com/ckm/sort/medium/Solution1305.java)
问题描述：

　　给定两个二叉搜索树`root1`和`root2`，将这两个二叉搜索树中的元素按照升序合并到一个数组中并返回。

- 每棵树最多5000个节点
- 节点值的范围为 [-10^5, 10^5]

示例：

```
Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
```
![示例一](./images/q_1305_1.png)
```
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:
Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:
Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:
Input: root1 = [1,null,8], root2 = [8,1]
```
![示例五](./images/q_1305_2.png)
```
Output: [1,1,8,8]
```

解法：

　　类似的题目有，两个BST的合并，两个有序数组的合并。

　　办法一：按照中序遍历的方式先把将其中一个树排好顺序，接下来继续按照中序遍历的方式依次取另一棵树的节点，按照插入排序的思路将节点值插入有序数组中。

### 1387 [MEDIUM][根据数字的`power`排序](../java/com/ckm/sort/medium/Solution1387.java)
问题描述：

　　整数的`power`的定义是，给定一个整数，按如下规则变化成1时所需的次数。

- 如果`x`是偶数，那么`x = x / 2`
- 如果`x`是奇数，那么`x = 3 * x + 1`

　　比如，`x = 3`时，`power`为`7`。`(3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)`

　　题目给定一个整数`lo`，一个整数`hi`以及一个整数`k`，我们需要找到`[lo, hi]`范围内所有整数的`power`然后按其升序排列，取出其中第`k`的那个数字。如果两个数字的`power`相同，则按数字大小升序排列。

```
1 <= lo <= hi <= 1000
1 <= k <= hi - lo + 1
```

示例：

```
Example 1:
Input: lo = 12, hi = 15, k = 2
Output: 13
Explanation: 12的power为9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
13 的power为 9
14 的power为 17
15 的power为 17
按power升序排列为 [12,13,14,15]. k = 2 对应的数字为 13.
12和13，14和15的power相同，按数字大小升序排列。

Example 2:
Input: lo = 1, hi = 1, k = 1
Output: 1

Example 3:
Input: lo = 7, hi = 11, k = 4
Output: 7
Explanation: [7, 8, 9, 10, 11] 的power分别是 [16, 3, 19, 6, 14].
按power的升序排列为 [8, 10, 11, 7, 9].
第4个数字为 7.

Example 4:
Input: lo = 10, hi = 20, k = 5
Output: 13

Example 5:
Input: lo = 1, hi = 1000, k = 777
Output: 570
```

解法：

　　题目主要是计算出给定整数的power值，接下来根据power排列大小即可。

### number [][]()
问题描述：

　　

示例：

```

```

解法：

　　
