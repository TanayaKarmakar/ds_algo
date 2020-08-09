package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
	List<List<Integer>> elements;
	private static final int MAX = 1000001;

    /** Initialize your data structure here. */
    public MyHashSet() {
        elements = new ArrayList<>();
        for(int i = 0; i < MAX; i++) {
        	elements.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int hashValue = key % MAX;
        List<Integer> values = elements.get(hashValue);
        for(Integer value: values) {
        	if(value == key)
        		return;
        }
        values.add(key);
    }
    
    public void remove(int key) {
        int hashValue = key % MAX;
        List<Integer> values = elements.get(hashValue);
        int indx = -1;
        for(int i = 0; i < values.size(); i++) {
        	if(values.get(i) == key) {
        		indx = i;
        		break;
        	}
        }
        if(indx == -1)
        	return;
        values.remove(indx);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashValue = key % MAX;
        List<Integer> values = elements.get(hashValue);
        for(Integer el: values) {
        	if(el == key)
        		return true;
        }
        return false;
    }
}

public class HashSetImplementation {

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println(hashSet.contains(1));    // returns true
		System.out.println(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);          
		System.out.println(hashSet.contains(2));    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2));  

	}

}
