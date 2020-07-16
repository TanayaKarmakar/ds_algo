package com.app.questions.dp;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumLeetcode523 {
	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int preSum = 0;
		
		int n = nums.length;
		
		map.put(0, -1);
		for(int i = 0; i < n; i++) {
			preSum += nums[i];
			
			if(k != 0)
				preSum = preSum % k;
			if(map.containsKey(preSum)) {
				if(i - map.get(preSum) > 1)
					return true;
			} else {
				map.put(preSum, i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		int[] nums = { 23, 2, 4, 6, 7 };
//		
//		System.out.println(checkSubarraySum(nums, 6));

		int[] nums = { 0, 1, 0, 1, 0, 1 };
		int k = 0;
		
		System.out.println(checkSubarraySum(nums, k));

	}

}
