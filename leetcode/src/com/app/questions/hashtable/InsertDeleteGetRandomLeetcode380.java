package com.app.questions.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
	Map<Integer, Integer> set;
	List<Integer> list;
	Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.containsKey(val)) {
        	return false;
        }
        list.add(val);
        set.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.isEmpty() || !set.containsKey(val))
        	return false;
        
        int indx = set.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(indx, lastElement);
        set.put(lastElement, indx);
        
        set.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
       int size = list.size();
       int min = 0;
       int max = size - 1;
       int randomNumber = rand.nextInt(max + 1 - min) + min;
       return list.get(randomNumber);
    }
}

public class InsertDeleteGetRandomLeetcode380 {

	public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		System.out.println(set.insert(0));
		System.out.println(set.insert(1));
		System.out.println(set.remove(0));
		System.out.println(set.insert(2));
		System.out.println(set.remove(1));
		System.out.println(set.getRandom());
		
//		System.out.println(set.insert(3));
//		System.out.println(set.insert(2));
//		System.out.println(set.remove(2));
//		System.out.println(set.insert(1));
//		System.out.println(set.insert(-3));
//		System.out.println(set.insert(-2));
//		System.out.println(set.remove(-2));
//		System.out.println(set.remove(3));
//		System.out.println(set.insert(-1));
//		System.out.println(set.remove(-3));
//		System.out.println(set.insert(1));
//		System.out.println(set.insert(-2));
//		System.out.println(set.insert(-2));
//		System.out.println(set.insert(-2));
//		System.out.println(set.insert(1));
//		System.out.println(set.getRandom());
//		System.out.println(set.insert(-2));
//		System.out.println(set.remove(0));
//		System.out.println(set.insert(-3));
//		System.out.println(set.insert(1));
	}

}
