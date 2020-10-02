package com.app.questions.hashtable;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class FirstUnique {
	Map<Integer, Integer> map;
	Set<Integer> set;

	public FirstUnique(int[] nums) {
		map = new LinkedHashMap<>();
		set = new LinkedHashSet<>();
		for (int el : nums) {
			map.put(el, map.getOrDefault(el, 0) + 1);
			if (map.get(el) == 1)
				set.add(el);
			else
				set.remove(el);
		}
	}

	public int showFirstUnique() {
		if (set.size() == 0)
			return -1;
		return set.stream().findFirst().get();
	}

	public void add(int value) {
		map.put(value, map.getOrDefault(value, 0) + 1);
		if (map.get(value) == 1)
			set.add(value);
		else
			set.remove(value);
	}
}

public class FirstUniqueNumberLeetcode1429 {

	public static void main(String[] args) {
		FirstUnique obj = new FirstUnique(new int[] { 2, 3, 5 });
		System.out.println(obj.showFirstUnique());
		obj.add(5);
		System.out.println(obj.showFirstUnique());
		obj.add(2);
		System.out.println(obj.showFirstUnique());
		obj.add(3);
		System.out.println(obj.showFirstUnique());
	}

}
