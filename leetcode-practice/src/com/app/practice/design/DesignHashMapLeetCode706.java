package com.app.practice.design;

import java.util.LinkedList;

class MyHashMap {
	private final int MAX = 1000001;
	private LinkedList<Integer>[] map;

	/** Initialize your data structure here. */
	public MyHashMap() {
		map = new LinkedList[MAX];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		map[key] = new LinkedList<>();
		map[key].add(value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		return map[key] == null ? -1: map[key].get(0);
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		if(map[key] != null)
			map[key] = null;
	}
}

public class DesignHashMapLeetCode706 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
