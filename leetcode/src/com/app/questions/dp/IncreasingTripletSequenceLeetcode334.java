package com.app.questions.dp;

public class IncreasingTripletSequenceLeetcode334 {
	private static boolean increasingTripletEfficient(int[] nums) {
		if (nums.length < 3)
			return false;
		int small = Integer.MAX_VALUE;
		int big = Integer.MAX_VALUE;

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if(nums[i] <= small)
				small = nums[i];
			else if(nums[i] <= big)
				big = nums[i];
			else
				return true;
		}
		return false;
	}

	private static boolean increasingTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		int n = nums.length;
		int[] dp = new int[n];

		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Integer.max(dp[i], dp[j] + 1);
				}
			}
			if (dp[i] == 3)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4, 1, 7 };

		boolean ans = increasingTriplet(nums);

		System.out.println(ans);
		
		ans = increasingTripletEfficient(nums);
		
		System.out.println(ans);
	}

}
