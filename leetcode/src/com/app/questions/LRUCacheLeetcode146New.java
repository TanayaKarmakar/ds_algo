package com.app.questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Item {
	int key;
	int value;
}

public class LRUCacheLeetcode146New {
	Deque<Item> dQ;
	Map<Integer, Item> map;
	int maxCap;
	int len;
	
	public LRUCacheLeetcode146New(int capacity) {
		maxCap = capacity;
		len = 0;
		dQ = new ArrayDeque<Item>(maxCap);
		map = new HashMap<>(maxCap);
	}
	
	public void put(int key, int value) {
		if(!map.containsKey(key)) {
			if(len == maxCap) {
				Item lastItem = dQ.peekLast();
				map.remove(lastItem.key);
				dQ.removeLast();
				len--;
			}
			Item item = new Item();
			item.key = key;
			item.value = value;
			dQ.addFirst(item);
			map.put(key, item);
			len++;
		} else {
			Item item = map.get(key);
			dQ.remove(item);
			item.value = value;
			dQ.addFirst(item);
			map.put(key, item);
		}
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			Item item = map.get(key);
			dQ.remove(item);
			dQ.addFirst(item);
			return item.value;
		}
		return -1;
	}
	

	public static void main(String[] args) {
		LRUCacheLeetcode146New obj = new LRUCacheLeetcode146New(2);
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
