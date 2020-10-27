package com.app.practice.design;

class MyHashSet {
	private boolean[] hash;
	private final int maxSize = 1000001;
	
	/** Initialize your data structure here. */
	public MyHashSet() {
		hash = new boolean[maxSize];
	}

	public void add(int key) {
		hash[key] = true;
	}

	public void remove(int key) {
		hash[key] = false;
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		return hash[key];
	}
}

public class DesignHashSetLeetcode705 {

	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add(1);
		set.add(2);
		
		System.out.println(set.contains(1));
		System.out.println(set.contains(3));
		
		set.add(2);
		System.out.println(set.contains(2));
		set.remove(2);
		System.out.println(set.contains(2));
	}

}
