package com.app.practice.array;

class MyHashSet {
	private boolean[] hash;

    public MyHashSet() {
        this.hash = new boolean[1000000];
    }
    
    public void add(int key) {
        hash[key] = true;
    }
    
    public void remove(int key) {
        hash[key] = false;
    }
    
    public boolean contains(int key) {
        return hash[key];
    }
}


public class DesignHashSetLeetcode705 {

	public static void main(String[] args) {
		MyHashSet mHashSet = new MyHashSet();
		mHashSet.add(1);
		mHashSet.add(2);
		
		System.out.println(mHashSet.contains(1));
		System.out.println(mHashSet.contains(3));
		
		mHashSet.add(2);
		
		System.out.println(mHashSet.contains(2));
		
		mHashSet.remove(2);
		
		System.out.println(mHashSet.contains(2));

	}

}
