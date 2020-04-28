package com.app.questions.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumberThanCurrentLeetcode1365 {
	public static int[] smallerNumbersThanCurrentEfficient(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			max = Integer.max(max, nums[i]);
		}
		
		int[] count = new int[max + 1];
		for(int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}
		
		for(int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}
		
		for(int i = 0; i < nums.length; i++) {
			int k = nums[i];
			if(k > 0) {
				nums[i] = count[k - 1];
			} else {
				nums[i] = 0;
			}
			
		}
		return nums;
	}
	
	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] temp = Arrays.copyOf(nums, nums.length);
		Arrays.sort(temp);
		Map<Integer, Integer> map = new HashMap<>();
		int n = temp.length;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(temp[i])) {
				map.put(temp[i], i);
			}
		}

		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = map.get(nums[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };

		int[] res = smallerNumbersThanCurrentEfficient(nums);

		System.out.println(Arrays.toString(res));

		nums = new int[] { 6, 5, 4, 8 };

		res = smallerNumbersThanCurrentEfficient(nums);

		System.out.println(Arrays.toString(res));

	}

}
