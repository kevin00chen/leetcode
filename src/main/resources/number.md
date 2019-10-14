　　主要记录数字相关的题目。

[TOC]

### 7 [整数反转](../java/com/ckm/number/Solution7.java)
问题描述：

　　给定一个整数，将其数字进行反转。

示例：

```
  Example 1:
  
  Input: 123
  Output: 321
  Example 2:
  
  Input: -123
  Output: -321
  Example 3:
  
  Input: 120
  Output: 21
```

解法：

　　去掉

### 9 [回文数字](../java/com/ckm/number/Solution9.java)
问题描述：

　　给定一个整数，判断其是否为回文数字。直接操作数字，不用将其转换为字符串，
和[回文字符串](../java/com/ckm/string/Solution5.java)的判断方法不相同。

示例：

```
Example 1:
Input: 121
Output: true

Example 2:
Input: -121
Output: false
Explanation: 从左到右为 -121，从右到左为 121-，所以为非回文数字。

Example 3:
Input: 10
Output: false
Explanation: 从右到左为01。所以为非回文数字。
```

解法：

　　在不转为字符串处理的情况下，可以将原数字进行反转，如果反转后得到的数字和原数字相等，则为回文数字。这种情况下需要注意反转后可能整数溢出。

　　所以，为了避免对溢出进行处理，另外一种方法是反转一半的数字，比如`1221`，`21`反转后得到`12`，和前面的`12`相等。
反转时需要注意以0结尾的数字提前处理。`while`循环中，由于只需要反转一半数字，所以没必要将原来的`x`全部循环完即`x >0`，只需要在`x > y`时继续就行。
对于`12321`，处理后得到的`y = 123`，此时`x = 12`，这是由于原数字有奇数位，所以在`return`语句中，`x == y / 10`。

### 12 [整数转罗马数字符号](../java/com/ckm/number/Solution12.java)
问题描述：

　　罗马数字符号由`I, V, X, L, C, D,  M`表示，其中

| 符号 | 数值 |
|---|---|
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

　　`2`表示为`II`，`12`表示为`XII`，`27`表示为`XXVII`。但是`4`不是`IIII`而是`IV`，`9`不是`VIIII`而是`IX`。

- I 可位于 V (5) 和 X (10) 之前，表示 4 和 9。 
- X 可位于 L (50) 和 C (100) 之前，表示 40 和 90。 
- C 可位于 D (500) 和 M (1000) 之前，表示 400 和 900。

　　给定一个`1 ~ 3999`之间的整数，返回其罗马数字表示方式。

示例：

```
Example 1:
Input: 3
Output: "III"

Example 2:
Input: 4
Output: "IV"

Example 3:
Input: 9
Output: "IX"

Example 4:
Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 5:
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

解法：

　　

### 8 [](../java/com/ckm/number/Solution8.java)
问题描述：

　　

示例：


解法：

　　