package com.app.practice.greedy;

public class JumpGameLeetcode55 {
	private static boolean canJump(int[] nums) {
		int n = nums.length;
		int lastIndx = n - 1;

		for(int i = n - 2; i >= 0; i--) {
			if(i + nums[i] >= lastIndx) {
				lastIndx = i;
			}
		}
		return lastIndx == 0;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		boolean ans = canJump(nums);

		System.out.println(ans);

		nums = new int[] { 3, 2, 1, 0, 4 };
		ans = canJump(nums);

		System.out.println(ans);
	}

}
