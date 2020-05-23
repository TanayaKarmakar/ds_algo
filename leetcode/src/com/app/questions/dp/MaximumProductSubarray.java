package com.app.questions.dp;

public class MaximumProductSubarray {
	private static int maxProductSubarray(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		int n = nums.length;
		int maxEndingHere = 1;
		int minEndingHere = 1;
		int maxSoFar = 1;
		int flag = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				maxEndingHere = maxEndingHere * nums[i];
				minEndingHere = Integer.min(1, minEndingHere * nums[i]);
				flag = 1;
			} else if (nums[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			} else {
				int tmp = maxEndingHere;
				maxEndingHere = Integer.max(1, minEndingHere * nums[i]);
				minEndingHere = tmp * nums[i];
			}
			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}
		if(flag == 0 && maxSoFar == 1)
			return 0;
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4 };
		int val = maxProductSubarray(nums);
		System.out.println(val);

		nums = new int[] { -2, 0, -1 };
		val = maxProductSubarray(nums);
		System.out.println(val);
		
		nums = new int[] {-1, -1};
		val = maxProductSubarray(nums);
		System.out.println(val);
	}

}
