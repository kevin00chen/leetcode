### 146 [LRU Cache](../java/com/ckm/struct/Solution146.java)
问题描述：

　　实现一个LRU Cache数据结构，需要支持get和put操作，按最近使用时间移除元素

　　`get(key)`方法：返回cache中指定key的值，如果找不到则返回`-1`
　　`put(key, value)`方法：向cache中插入元素，如果达到了cache的最大容量，则会先从cache中删除最少访问的元素后再插入。

　　`put`和`get`需要`O(1)`时间复杂度。

示例：

```
  LRUCache cache = new LRUCache( 2 /* capacity */ );
  
  cache.put(1, 1);
  cache.put(2, 2);
  cache.get(1);       // returns 1
  cache.put(3, 3);    // evicts key 2
  cache.get(2);       // returns -1 (not found)
  cache.put(4, 4);    // evicts key 1
  cache.get(1);       // returns -1 (not found)
  cache.get(3);       // returns 3
  cache.get(4);       // returns 4
```

解法：

　　

### 2 [](../java/com/ckm/Solution.java)
问题描述：

　　

示例：


解法：

　　