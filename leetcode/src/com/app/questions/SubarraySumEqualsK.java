package com.app.questions;

public class SubarraySumEqualsK {
	private static int countSubarray(int[] nums, int k) {
		int start = 0;
		int n = nums.length;
		int subarrCount = 0;

		while (start < n) {
			int sum = 0;
			for(int i = start; i < n; i++) {
				sum += nums[i];
				if(sum == k)
					subarrCount++;
			}
			start++;
		}

		return subarrCount;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1 };
		int k = 2;

		System.out.println(countSubarray(arr, k));

	}

}
