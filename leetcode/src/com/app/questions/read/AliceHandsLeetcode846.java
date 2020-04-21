package com.app.questions.read;

import java.util.TreeMap;

public class AliceHandsLeetcode846 {
	
	private static boolean canArrange(int[] nums, int W) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int n = nums.length;
		
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			}
		}
		
		while(map.size() > 0) {
			int firstKey = map.firstKey();
			for(int i = firstKey; i < firstKey + W; i++) {
				if(!map.containsKey(i))
					return false;
				int count = map.get(i);
				if(count == 1)
					map.remove(i);
				else
					map.put(i, --count);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };

		System.out.println(canArrange(nums, 3));

		nums = new int[] { 1, 2, 3, 4, 5 };

		System.out.println(canArrange(nums, 4));

		nums = new int[] { 1, 2, 4, 3, 6, 7, 8, 9, 10 };

		System.out.println(canArrange(nums, 3));

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println(canArrange(nums, 3));
		
		nums = new int[] {2,1};
		
		System.out.println(canArrange(nums, 2));

	}

}
