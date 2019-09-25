　　题目列表

### 1 [两数求和](./src/main/java/com/ckm/normal/Solution1.java)
问题描述：

　　给定一个整数数组，返回和为指定数字的元素下标。每个元素只能使用一次。

示例：
```
nums = [2, 7, 11, 15], target = 9,

nums[0] + nums[1] = 2 + 7 = 9,

返回 [0, 1].
```
解法：

　　除了两层遍历的暴力解法之外，还可以用HashMap来解决，遍历数组，target - 当前元素 之差如果不在该map中，则map中添加元素，否则直接返回下标。

### 2 [两数求和](./src/main/java/com/ckm/normal/Solution2.java)
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

### 3 [最长非重复子字符串](./src/main/java/com/ckm/normal/Solution3.java)
问题描述：

　　给定一个字符串，返回该字符串中非重复字符子串的最大长度。

示例：

示例 1:

```
Input: "abcabcbb"
Output: 3 
Explanation: 最长非重复子串为 "abc", 长度 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: 最长非重复子串为 "b", 长度 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: 最长非重复子串为 "wke", 长度 3. 
```

解法：

　　1、遍历一次字符串，维护一个<字符, index>的map结构，当遇到重复字符时，计数归零，新计数起点值为两个相同字符之间字符的个数。
需要注意`abba`这种结构，第一个`a`出现在`b`之前，此时新的计数起点只能从第二个`b`开始。

　　2、维护一个滑动窗口`[i, j)`，该窗口中的元素全部不相同。维护一个`Set`记录不同的字符，每次使`j`向后移动一位，当新字符第一次出现，则`j`继续向后移动,
否则从`i`开始移除`Set`中的元素，直到不再出现重复元素为止。然后继续移动`j`，直到`i`和`j`都遍历完全部元素。

### 4 [两个有序数组中位数计算](./src/main/java/com/ckm/normal/Solution4.java)
问题描述：

　　两个排好序的数组（两个数组不同时为空），分别包含m个和n个元素，计算中位数。时间复杂度`O(log (m+n))`

示例：

```
Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```

解法：

　　

### 5 [寻找字符串的最大回文子串](./src/main/java/com/ckm/normal/Solution5.java)
问题描述：

　　如题

示例：

```
Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
```

解法：

　　(1) 反转原字符串后，求两个字符串的最长公共子序列

　　(2) 回文字符串关于某个字符左右对称。所以，判断字符串是否为回文时可以从某个字符向两边扩展进行判断。对于`aba`和`abba`这种字符数分为奇偶的情况，有一种快捷方法，即对字符串进行扩展，
如`#a#b#a#`或者`#a#b#b#a#`，在整个字符串开头和结尾，以及每个字符中间都加上`#`，就可以对任意长度字符串进行同样的处理逻辑。

　　(3) 动态规划。如果父串位回文，那么里面的子串也必为回文，否则不成立。如下图所示：

![动态规划图解](./src/main/resources/images/s5-1.png)

　　递推公式如下，其中`S[i]`和`S[j]`是字符串`S`中的字符：

<img src="http://latex.codecogs.com/gif.latex?f(n)=\begin{cases}\\ true, &i = j\\S[i] = S[j], &j=i+1\\S[i]=S[j]\ and\ f(i+1, j-1), &j > i + 1\end{cases}" />

　　(4) Manacher算法

　　与方法2类似，首先对原字符串进行扩充，统一奇偶字符数时的处理逻辑。接下来利用回文串的特性求解。

　　如下图所示，每次向后遍历一个字符，使用变量`right`记录当前所遍历的字符为中心的回文子串所能触及的最右边界，与该边界对应的字符下标为`id`，则距离该下标`k`并且关于下标对称的两个字符分别为
`id - k`和`id + k`。以`rad[]`记录各字符为中心的最大回文串半径。

　　在第一种情况下，`id - k`已经遍历过，以它为中心的最大回文串半径超出了以`id`为中心的最大回文串半径时，即`rad[id - k] > rad[id] - k`表示图中橙色超出蓝色的长度。在这种情况下，
关于`id`对称的点`id + k`的边界会超出`right`，此时临时记录`rad[id + k]`的值为`id + k`到`right`的距离，即`rad[id] - k`。然后超出`right`的部分，同时从字符串两端向外扩展，
如果两端字符相同，则逐步增加`rad[id + k]`的值，同时更新`id = id + k`，并且增大`right`。

　　在第二种情况下，`id - k`的回文串在以`id`为中心的回文串中包含，此时`rad[id + k] = rad[id - k]`。

　　综上两种情况，`rad[id + k] = Min(rad[id - k], rad[id] - k)`。在代码中表达为`Math.min(rad[2 * id - i], rad[id] - (i - id))`，其中`i - id`为当前遍历的点`i`距离`id`中心的距离`k`。

![动态规划图解](./src/main/resources/images/s5-2.png)

### 6 [](./src/main/java/com/ckm/normal/Solution6.java)
问题描述：

　　字符串"PAYPALISHIRING"是按照`|/|`形排列的，即首先从上往下依次显示字符，然后斜向上到顶后继续第二列从上往下。如下所示，
  
  P   A   H   N
  A P L S I I G
  Y   I   R

　　排列好后按行读取字符并形成新的字符串，"PAHNAPLSIIGYIR"。
  
　　代码接收一个字符串参数，以及整数的行数，实现字符串的zigzag排列。

示例：

```
  Example 1:
  
  Input: s = "PAYPALISHIRING", numRows = 3
  Output: "PAHNAPLSIIGYIR"
  Example 2:
  
  Input: s = "PAYPALISHIRING", numRows = 4
  Output: "PINALSIGYAHRPI"
  Explanation:
  
  P     I    N
  A   L S  I G
  Y A   H R
  P     I
```

解法：

　　对于`n`行的zigzag字符，可以用`n + (n - 2)`为一组，每组占`1 + (n - 2)`列，字符串总字符数除以每组的元素个数即可得到总共的组数，然后乘以列数，就可以构造出一个二维数组。

　　遍历字符串，按从上往下的顺序设置数组后，再按从左至右的顺序依次读取。没有字符的地方用空字符串表示。

### 2 [](./src/main/java/com/ckm/normal/Solution1.java)
问题描述：

　　

示例：


解法：

　　

### 2 [](./src/main/java/com/ckm/normal/Solution1.java)
问题描述：

　　

示例：


解法：

　　

### 2 [](./src/main/java/com/ckm/normal/Solution1.java)
问题描述：

　　

示例：


解法：

　　

### 2 [](./src/main/java/com/ckm/normal/Solution1.java)
问题描述：

　　

示例：


解法：

　　
