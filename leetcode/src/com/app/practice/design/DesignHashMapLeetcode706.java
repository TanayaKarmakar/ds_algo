package com.app.practice.design;

import java.util.LinkedList;

class MyHashMap {
	private LinkedList<Integer>[] map;
	private final int MAX = 1000001;
	private final int HASH = 2069;
	

	/** Initialize your data structure here. */
	public MyHashMap() {
		//map = new LinkedList[MAX];
		map = new LinkedList[MAX];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		if(map[key] == null)
			map[key] = new LinkedList<>();
		map[key].add(0, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		return map[key] == null ? -1 : map[key].get(0);
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		map[key] = null;
	}
}

public class DesignHashMapLeetcode706 {

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		map.put(1, 1);
		map.put(2, 2);
		
		System.out.println(map.get(1));
	}

}
