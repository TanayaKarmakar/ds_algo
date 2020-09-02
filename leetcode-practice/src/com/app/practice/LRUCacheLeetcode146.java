package com.app.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Item {
	int key;
	int value;
}

class LRUCache {
	int capacity;
	int len = 0;
	Map<Integer, Item> map;
	Deque<Item> q;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        q = new ArrayDeque<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	Item item = map.get(key);
        	q.remove(item);
        	q.addFirst(item);
        	return item.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
        	if(len == capacity) {
        		Item item = q.peekLast();
        		map.remove(item.key);
        		q.removeLast();
        		len--;
        	} 
        	Item item = new Item();
        	item.key = key;
        	item.value = value;
        	
        	q.addFirst(item);
        	map.put(key, item);
        	len++;
        } else {
        	Item item = map.get(key);
        	q.remove(item);
        	item.value = value;
        	q.addFirst(item);
        	map.put(key, item);
        }
    }
} 

public class LRUCacheLeetcode146 {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		
		
		System.out.println(cache.get(1));
		
		cache.put(3, 3);
		
		System.out.println(cache.get(2));
		
		cache.put(4, 4);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));

	}

}
