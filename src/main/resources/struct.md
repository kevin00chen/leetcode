　　主要记录数据结构相关问题

[TOC]

### 146 [MEDIUM][LRU Cache](../java/com/ckm/struct/Solution146.java)
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

　　只需要维护一个`Queue`，`get`元素时，如果元素在该队列中，先将其移除，然后重新添加到尾部。
`put`元素时，如果元素在其中，调用一次`get`方法将其调整到尾部，如果元素不在其中并且`capacity`达到最大，则移除头部一个元素，然后将当前元素添加到尾部。

### 460 [HARD][LFU Cache](../java/com/ckm/struct/LFUCache.java)
问题描述：

　　实现一个LFU Cache数据结构，需要在`O(1)`的时间复杂度内支持`put`和`get`方法，
  
　　`get(key)`方法： 获取指定key的元素值，如果不存在就返回`-1`
　　`put(key, value)`方法： 保存指定`key`的`value`值，如果Cache达到其容量上限，就从其中移除使用次数最少的元素，然后再继续添加。

　　注意，LFU Cache需要同时兼容LRU的特性，后`put`的元素保留更久。

示例：

```
  Example:
  
  LFUCache cache = new LFUCache( 2 /* capacity */ );
  
  cache.put(1, 1);
  cache.put(2, 2);
  cache.get(1);       // returns 1
  cache.put(3, 3);    // evicts key 2
  cache.get(2);       // returns -1 (not found)
  cache.get(3);       // returns 3.
  cache.put(4, 4);    // evicts key 1.
  cache.get(1);       // returns -1 (not found)
  cache.get(3);       // returns 3
  cache.get(4);       // returns 4
```

解法：

　　LFU Cache比LRU Cache复杂，因为LFU Cache首先按使用次数排序，在使用次数相同的情况下还需要按照操作顺序排序。
　　在代码中维护一个`Map<Int, Int>`用于在`O(1)`复杂度内`put`和`get`元素，
维护一个`Map<Int, Int>`用来记录每个元素的操作次数，不管是`get`还是`set`都递增其中的值。
维护一个`Map<Int, Set<Int>>`用来记录相同操作次数的元素，但是，由于相同次数的元素需要按照操作先后有序，所以使用`LinkedHashSet`来记录。

　　需要注意的是在`put`时，当该元素已存在，可以理解为间接的调用一次`put`方法，调整其次数顺序。移除元素时需要优先移除`LinkedHashSet`头部元素。

### 8 [](../java/com/ckm/struct/LRUCache.java)
问题描述：

　　

示例：


解法：

　　
