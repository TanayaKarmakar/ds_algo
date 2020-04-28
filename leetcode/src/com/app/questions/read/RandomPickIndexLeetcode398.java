package com.app.questions.read;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndexLeetcode398 {
	Map<Integer, List<Integer>> map = new HashMap<>();
	
	public RandomPickIndexLeetcode398(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				map.put(nums[i], indices);
			} else {
				map.get(nums[i]).add(i);
			}
		}
	}
	
	public int pick(int target) {
		List<Integer> indices = map.get(target);
		Random rand = new Random();
		return indices.get(rand.nextInt(indices.size()));
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,3,3};
		RandomPickIndexLeetcode398 obj = new RandomPickIndexLeetcode398(nums);
		
		System.out.println(obj.pick(3));
		

	}

}
