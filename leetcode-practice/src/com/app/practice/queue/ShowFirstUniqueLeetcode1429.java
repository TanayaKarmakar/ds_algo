package com.app.practice.queue;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class NumberItem {
	int number;
	int frequency;

	public NumberItem(int number, int frequency) {
		this.number = number;
		this.frequency = frequency;
	}

	public String toString() {
		return number + " - " + frequency;
	}
}

class FirstUnique {
	Map<Integer, NumberItem> map;
	Queue<NumberItem> q;

	public FirstUnique(int[] nums) {
		map = new LinkedHashMap<>();
		q = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				NumberItem item = new NumberItem(nums[i], 1);
				map.put(nums[i], item);
				q.add(item);
			} else {
				q.remove(map.get(nums[i]));
				map.get(nums[i]).frequency++;
			}
		}
	}

	public int showFirstUnique() {
		if (q.isEmpty())
			return -1;
		return q.peek().number;
	}

	public void add(int value) {
		if(!map.containsKey(value)) {
			NumberItem item = new NumberItem(value, 1);
			map.put(value, item);
			q.add(item);
			return;
		}
		NumberItem item = map.get(value);
		if (item.frequency == 1)
			q.remove(item);
		item.frequency++;
	}
}

public class ShowFirstUniqueLeetcode1429 {

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
