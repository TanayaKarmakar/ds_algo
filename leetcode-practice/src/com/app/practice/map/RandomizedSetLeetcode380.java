package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
	Random rand;
	Map<Integer, Integer> map;
	List<Integer> list;
	
	public RandomizedSet() {
		rand = new Random();
		map = new HashMap<>();
		list = new ArrayList<>();
	}
	
	public boolean insert(int val) {
		if(map.containsKey(val))
			return false;
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}
	
	public boolean remove(int val) {
		if(!map.containsKey(val))
			return false;
		int indx = map.get(val);
		int lastElement = list.get(list.size() - 1);
		list.set(indx, lastElement);
		list.remove(list.size() - 1);
		map.put(lastElement, indx);
		map.remove(val);
		return true;
		
	}
	
	public int getRandom() {
		int min = 0;
		int max = list.size();
		int rIndx = rand.nextInt(max - min) + min;
		return list.get(rIndx);
	}
	
}

public class RandomizedSetLeetcode380 {

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		System.out.println(obj.insert(1));
		System.out.println(obj.insert(2));
		System.out.println(obj.remove(2));

	}

}
