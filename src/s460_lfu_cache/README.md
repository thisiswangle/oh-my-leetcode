# LeetCode #146 LRU Cache 解题思路

## 题目描述

[LeetCode原题地址](https://leetcode.com/problems/lru-cache/)

设计和实现最近最少使用(LRU)缓存数据结构，这个缓存支持 get/put 操作。

* `get(key)`: 如果缓存命中，则返回key对应的值，假设值都是正数，不命中就返回 -1
* `put(key, value)`: 添加缓存项，如果缓存达到容量上限，那么在插入新值之前，把最少使用的值删掉

这两个操作时间复杂度都要求是 O(1)。

例如:

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

## 解题思路

// TODO


## 代码实现

 [#146 Lru Cache](src/s146_lru_cache/LRUCache.java)


