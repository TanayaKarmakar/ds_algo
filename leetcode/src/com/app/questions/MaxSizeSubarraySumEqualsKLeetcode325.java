package com.app.questions;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsKLeetcode325 {
	public static int maxSubArrayLen(int[] nums, int k) {
		int res = 0;
		int preSum = 0;
		int n = nums.length;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			preSum += nums[i];
			if(preSum == k)
				res = i + 1;
			if(!map.containsKey(preSum))
				map.put(preSum, i);
			if(map.containsKey(preSum - k)) {
				res = Integer.max(res, i - map.get(preSum - k));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, -1, 5, -2, 3};
		
		int k = 3;
		
		int maxLen = maxSubArrayLen(nums, k);
		
		System.out.println(maxLen);
		
		nums = new int[] {-2, -1, 2, 1};
		
		k = 1;
		
		maxLen = maxSubArrayLen(nums, k);
		
		System.out.println(maxLen);

	}

}
