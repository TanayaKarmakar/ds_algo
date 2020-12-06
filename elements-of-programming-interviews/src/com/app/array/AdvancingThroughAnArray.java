package com.app.array;

public class AdvancingThroughAnArray {
	private static boolean canBeWon(int[] nums) {
		int n = nums.length;
		int lastKnownPosition = n - 1;

		for (int i = n - 2; i >= 0; i--) {
			if (i + nums[i] >= lastKnownPosition)
				lastKnownPosition = i;
		}

		return lastKnownPosition == 0;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 1, 0, 2, 0, 1 };
		boolean ans = canBeWon(nums);

		System.out.println(ans);

		nums = new int[] { 3, 2, 0, 0, 2, 0, 1 };
		
		ans = canBeWon(nums);

		System.out.println(ans);
	}

}
