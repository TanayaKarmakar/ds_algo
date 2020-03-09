package com.app.questions;

public class JumpGame {
	private static boolean canJump(int[] nums) {
		int n = nums.length;
		int maxReachDistance = 0;

		for (int i = 0; i < n; i++) {
			if (i > maxReachDistance)
				break;
			maxReachDistance = Integer.max(maxReachDistance, i + nums[i]);
		}

		return maxReachDistance >= (nums.length - 1);
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(nums));

		nums = new int[] { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums));
	}

}
