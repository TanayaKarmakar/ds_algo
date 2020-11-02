package com.app.practice.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class Item {
	int key;
	int value;
	
	public Item(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class CacheItem {
	Item item;
	int accessCount;
	
	public CacheItem(Item item, int accessCount) {
		this.item = item;
		this.accessCount = accessCount;
	}
}

class LFUCache {
	Map<Integer, CacheItem> map;
	TreeMap<Integer, Deque<CacheItem>> lfuMap;
	int maxCap;
	int currentCap;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        lfuMap = new TreeMap<>();
        maxCap = capacity;
        currentCap = 0;
    }
    
    public int get(int key) {
    	if(maxCap == 0) return -1;
        if(!map.containsKey(key))
        	return -1;
        CacheItem item = map.get(key);
        lfuMap.get(item.accessCount).remove(item);
        if(lfuMap.get(item.accessCount).size() == 0)
			lfuMap.remove(item.accessCount);
        item.accessCount++;
        
        map.put(key, item);
        if(!lfuMap.containsKey(item.accessCount))
    		lfuMap.put(item.accessCount, new LinkedList<>());
        lfuMap.get(item.accessCount).addFirst(item);
        return item.item.value; 
    }
    
    public void put(int key, int value) {
    	if(maxCap == 0) return;
    	CacheItem cItem = null;
        if(!map.containsKey(key)) {
        	Item item = new Item(key, value);
        	int accessCount = 1;
        	cItem = new CacheItem(item, accessCount);
        	if(currentCap == maxCap) {
        		Deque<CacheItem> cItemQ = lfuMap.firstEntry().getValue();
        		CacheItem itemToBeRemoved = cItemQ.pollLast();
        		map.remove(itemToBeRemoved.item.key);
        		if(lfuMap.get(itemToBeRemoved.accessCount).size() == 0)
        			lfuMap.remove(itemToBeRemoved.accessCount);
        	} else {
        		currentCap++;
        	}
        } else {
        	cItem = map.get(key);
        	int prevAccessCount = cItem.accessCount;
        	Deque<CacheItem> itemQ = lfuMap.get(prevAccessCount);
        	itemQ.remove(cItem);
        	
        	if(lfuMap.get(prevAccessCount).size() == 0)
    			lfuMap.remove(prevAccessCount);
        	
        	cItem.item.value = value;
        	cItem.accessCount++;
        	
        }
        map.put(key, cItem);
    	if(!lfuMap.containsKey(cItem.accessCount))
    		lfuMap.put(cItem.accessCount, new LinkedList<>());
    	lfuMap.get(cItem.accessCount).addFirst(cItem);
    }
}


public class LFUCacheLeetcode460 {

	public static void main(String[] args) {
		LFUCache obj = new LFUCache(10);
		
		obj.put(10, 13);
		
		obj.put(3, 17);
		
		obj.put(6, 11);
		
		obj.put(10, 5);
		
		obj.put(9, 10);
		
		System.out.println(obj.get(13));
		
		obj.put(2, 19);
		
		System.out.println(obj.get(2));
		
		System.out.println(obj.get(3));
		
		obj.put(5, 25);
		
		System.out.println(obj.get(8));
		
		obj.put(9, 22);
		
		obj.put(5, 5);
		
		obj.put(1, 30);
		
		System.out.println(obj.get(11));
		
		obj.put(9, 12);
	}

}
