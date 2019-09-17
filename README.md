　　题目列表

### 1 两数求和
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

[Solution](./src/main/java/com/ckm/normal/Solution1.java)

### 2 两数求和
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

[Solution](./src/main/java/com/ckm/normal/Solution2.java)

### 2 最长非重复子字符串 
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

　　

[Solution](./src/main/java/com/ckm/normal/Solution1.java)

### 2 
问题描述：

　　

示例：


解法：

　　

[Solution](./src/main/java/com/ckm/normal/Solution1.java)