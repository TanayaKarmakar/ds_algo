package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Solution {
	Map<Integer, List<Integer>> map;
	Random rand;

	public Solution(int[] nums) {
		map = new HashMap<>();
		rand = new Random();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<>());
			map.get(nums[i]).add(i);
		}
	}

	public int pick(int target) {
		List<Integer> indices = map.get(target);
		if (indices.size() == 1)
			return indices.get(0);
		int rIndx = rand.nextInt(indices.size());
		return indices.get(rIndx);
	}
}

public class RandomPickIndexLeetcode398 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 3 };
		Solution obj = new Solution(nums);
		
		System.out.println(obj.pick(3));
		
		System.out.println(obj.pick(1));

	}

}
