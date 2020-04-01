package com.app.questions;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	private static int countSubarray(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0, 1);
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
//		int start = 0;
//		int n = nums.length;
//		int subarrCount = 0;
//
//		while (start < n) {
//			int sum = 0;
//			for(int i = start; i < n; i++) {
//				sum += nums[i];
//				if(sum == k)
//					subarrCount++;
//			}
//			start++;
//		}
//
//		return subarrCount;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1 };
		int k = 2;

		System.out.println(countSubarray(arr, k));

	}

}
