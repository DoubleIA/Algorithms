package com.doubleia.linear.linkedlist;

import java.util.HashMap;


/**
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * 						it should invalidate the least recently used item before inserting a new item.
 * 
 * @author wangyingbo
 *
 */
public class LRUCache {
	private final int MAX_CACHE_SIZE;
	private Cache first;
	private Cache last;
	
	private HashMap<Integer, Cache> hashMap; 
	
	// @param capacity, an integer
	public LRUCache(int capacity) {
		// write your code here
		MAX_CACHE_SIZE = capacity;
		hashMap = new HashMap<Integer, Cache>();
	}

	// @return an integer
	public int get(int key) {
		// write your code here
		Cache cache = hashMap.get(key);
		if (cache == null)
			return -1;
		moveToFirst(cache);
		return cache.value;
	}

	private void moveToFirst(Cache cache) {
		if (cache == first)
			return;
		if (cache == last)
			last = cache.pre;
		if (cache.pre != null)
			cache.pre.next = cache.next;
		if (cache.next != null)
			cache.next.pre = cache.pre;
		first.pre = cache;
		cache.next = first;
		cache.pre = null;
		first = cache;
	}

	// @param key, an integer
	// @param value, an integer
	// @return nothing
	public void set(int key, int value) {
		// write your code here
		Cache cache = hashMap.get(key);
		if (cache == null) {
			if (hashMap.size() >= MAX_CACHE_SIZE) {
				hashMap.remove(last.key);
				removeLast();
			}
			cache = new Cache();
			cache.key = key;
		}
		cache.value = value;
		if (first == null) {
			first = cache;
			last = cache;
		} else {
			moveToFirst(cache);
		}
		hashMap.put(key, cache);
	}
	
	private void removeLast() {
		if (last != null) {
			hashMap.remove(last.key);
			last = last.pre;
			if (last == null)
				first = null;
			else
				last.next = null;
		}
	}

	class Cache {
		public Cache pre;
		public Cache next;
		public int key;
		public int value;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		System.out.println(cache.get(2));
		cache.set(4,1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
	
}
