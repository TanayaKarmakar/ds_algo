package com.app.practice.array;

public class JumpGameLeetcode55 {
	private static boolean canJump(int[] nums) {
		int lastKnownPosition = nums.length - 1;
		int n = nums.length;

		for (int i = n - 2; i >= 0; i--) {
			if (i + nums[i] >= lastKnownPosition) {
				lastKnownPosition = i;
			}
		}

		return lastKnownPosition == 0;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(nums));

		nums = new int[] { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums));

	}

}
