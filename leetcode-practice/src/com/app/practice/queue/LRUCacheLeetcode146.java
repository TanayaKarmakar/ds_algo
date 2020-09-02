package com.app.practice.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Item {
	int key;
	int value;

	public Item(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class LRUCache {
	Map<Integer, Item> map;
	Deque<Item> q;
	int maxCap;
	int currentCap;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		q = new LinkedList<>();
		maxCap = capacity;
	}

	public void put(int key, int value) {
		if (!map.containsKey(key)) {
			Item newItem = new Item(key, value);
			if (currentCap == maxCap) {
				Item item = q.pollLast();
				map.remove(item.key);
			} else {
				currentCap++;
			}
			map.put(key, newItem);
			q.addFirst(newItem);
		} else {
			Item item = map.get(key);
			q.remove(item);

			Item newItem = new Item(key, value);
			map.put(key, newItem);
			q.addFirst(newItem);
		}
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Item item = map.get(key);
		q.remove(item);
		q.addFirst(item);
		return item.value;
	}
}

public class LRUCacheLeetcode146 {

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(2);

		obj.put(1, 1);
		obj.put(2, 2);

		System.out.println(obj.get(1));

		obj.put(3, 3);

		System.out.println(obj.get(2));
		
		obj.put(4, 4);
		
		System.out.println(obj.get(1));
		
		System.out.println(obj.get(3));
		
		System.out.println(obj.get(4));
	}

}
